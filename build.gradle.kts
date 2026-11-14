plugins {
	id("net.fabricmc.fabric-loom-remap")
	`maven-publish`
}

repositories {
	mavenCentral()
}

loom {
	splitEnvironmentSourceSets()

	mods {
		register("looparium") {
			sourceSet(sourceSets.main.get())
			sourceSet(sourceSets.getByName("client"))
		}
	}
}

fabricApi {
	configureDataGeneration {
		client = true
		modId = "looparium"
	}
}

dependencies {
	minecraft("com.mojang:minecraft:${providers.gradleProperty("minecraft_version").get()}")
	mappings("net.fabricmc:yarn:${providers.gradleProperty("yarn_mappings").get()}:v2")

	modImplementation("net.fabricmc:fabric-loader:${providers.gradleProperty("loader_version").get()}")
	modImplementation("net.fabricmc.fabric-api:fabric-api:${providers.gradleProperty("fabric_api_version").get()}")

	val libs = subprojects.filter { it.path.startsWith(":libs:") }
	libs.forEach { lib ->
		implementation(project(path = lib.path, configuration = "namedElements"))
		include(project(lib.path))
	}
}

tasks.processResources {
	val version = version
	inputs.property("version", version)

	filesMatching("fabric.mod.json") {
		expand("version" to version)
	}
}

tasks.withType<JavaCompile>().configureEach {
	options.release = 21
}

java {
	withSourcesJar()

	sourceCompatibility = JavaVersion.VERSION_21
	targetCompatibility = JavaVersion.VERSION_21
}

tasks.jar {
	val projectName = project.name
	inputs.property("projectName", projectName)

	from("LICENSE") {
		rename { "${it}_$projectName" }
	}
	from("NOTICE") {
		rename { "${it}_$projectName" }
	}
}