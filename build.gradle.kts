plugins {
    kotlin("jvm") version "2.4.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
    testImplementation("org.junit.jupiter:junit-jupiter:6.1.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.11.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        // ex17's hint system: warn when the result of a stdlib/@MustUseReturnValues
        // function is silently dropped (experimental, KEEP-0412).
        freeCompilerArgs.add("-Xreturn-value-checker=check")
    }
}

// ex16's legacy Java program lives alongside the Kotlin sources it gets refactored into.
sourceSets {
    main {
        java.srcDir("src/main/kotlin")
    }
}
