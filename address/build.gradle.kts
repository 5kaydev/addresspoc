import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    alias(libs.plugins.jib)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
}

val imageRepoUser: String? by project
val imageRepoPassword: String? by project

application {
    mainClass = "com.geico.ws.address.AddressAPIApplication"
}

dependencies {
    implementation(libs.commons.lang3)
    implementation(libs.starter.graphql)
    implementation(libs.starter.webflux)

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
//        image = "myjava:20240313-1"
//        auth {
//            username = imageRepoUser
//            password = imageRepoPassword
//        }
//    }
//    dockerClient {
//        executable = "docker"
//    }
    from {
        image = "docker://myjava:20240316-1"
    }
    to {
        image = "addresspoc-fe-rest:20240316-1"
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
