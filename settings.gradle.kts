pluginManagement {
	repositories {
		maven {
			name = "Fabric"
			url = uri("https://maven.fabricmc.net/")
		}
		mavenCentral()
		gradlePluginPortal()
	}

	plugins {
		id("net.fabricmc.fabric-loom-remap") version providers.gradleProperty("loom_version")
	}
}

file("libs").listFiles()
	?.filter { it.isDirectory && File(it, "build.gradle.kts").exists() }
	?.forEach { dir ->
		include(":libs:${dir.name}")
		project(":libs:${dir.name}").projectDir = dir
	}

rootProject.name = "looparium"