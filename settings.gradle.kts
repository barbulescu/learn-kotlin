plugins {
    // Auto-downloads the JDK required by the toolchain in build.gradle.kts,
    // so participants don't need JDK 21 pre-installed.
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "learn-kotlin"
