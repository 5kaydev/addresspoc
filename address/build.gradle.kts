import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.google.cloud.tools.jib") version "3.4.1"
}

val imageRepoUser: String? by project
val imageRepoPassword: String? by project

application {
    mainClass = "com.geico.ws.address.AddressAPIApplication"
}

dependencies {
    implementation(libs.commons.lang3)
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

jib {
//    from {
//        image = "mvisee/myjava:20240313-1"
//        auth {
//            username = imageRepoUser
//            password = imageRepoPassword
//        }
//    }
//    dockerClient {
//        executable = "docker"
//    }
    from {
        image = "docker://mvisee/myjava:20240313-1"
    }
    to {
        image = "mvisee/testjib:20240314-3"
        auth {
            username = imageRepoUser
            password = imageRepoPassword
        }
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
