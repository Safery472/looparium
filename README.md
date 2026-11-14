# Looparium

A liminal-space dimension mod for Minecraft 1.21.1 (Fabric).

Looparium adds a separate dimension built around liminal aesthetics:
endless corridors, muted lighting, and spaces that feel familiar yet unsettling.
It is designed as a self-contained map/mod experience rather than a traditional progression mod.

## Requirements

- Minecraft **1.20.1**
- **Fabric Loader** `0.19.5` or newer
- **Fabric API** `0.116.12+1.21.1` or newer
- **Java 21** for running the game
- **Java 21** for running Gradle / building the mod (required by Loom 1.15.5)

## Building

Clone the repository and run:

```bash
./gradlew build
```

The built mod jar will be in `build/libs/`.

If Gradle needs to download a distribution, make sure `gradle-wrapper.properties` points to a reachable mirror or local file. See the Fabric Documentation for IDE setup:

https://docs.fabricmc.net/develop/getting-started/creating-a-project#setting-up

## Installation

1. Install Fabric Loader for Minecraft 1.21.1.
2. Put Fabric API and the Looparium jar into your `mods/` folder.
3. Launch the game with the Fabric profile.

## License

Looparium is licensed under the **Apache License 2.0**. See `LICENSE` for the full text and `NOTICE` for copyright attribution.

Third-party assets and dependencies retain their original licenses. If you redistribute a modified version, keep the `LICENSE` and `NOTICE` files and mark modified files as changed.

## Links

- Sources: https://github.com/Safery472/looparium
- Issues: https://github.com/Safery472/looparium/issues