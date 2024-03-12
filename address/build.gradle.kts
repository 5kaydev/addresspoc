
plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
}

application {
    // Define the main class for the application.
    mainClass = "com.geico.ws.address.AddressAPIApplication"
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.springframework.boot:spring-boot-starter-graphql")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
