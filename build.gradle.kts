plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.spring") version "1.9.23"
    id("io.gitlab.arturbosch.detekt") version("1.23.6")
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.quicklybly"
version = "0.0.1"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // spring
    implementation("org.springframework.boot", "spring-boot-starter-actuator")
    implementation("org.springframework.boot", "spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot", "spring-boot-starter-web")
    developmentOnly("org.springframework.boot", "spring-boot-devtools")

    // kotlin
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")
    implementation("com.fasterxml.jackson.module", "jackson-module-blackbird")
    implementation("org.jetbrains.kotlin", "kotlin-reflect")
    implementation("io.github.oshai", "kotlin-logging-jvm", libs.versions.kotlinLogging.get())

    // observability
    runtimeOnly("io.micrometer", "micrometer-registry-prometheus")

    // db
    runtimeOnly("org.postgresql", "postgresql")
    implementation("org.liquibase", "liquibase-core")

    // tests
    testImplementation("org.springframework.boot", "spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin", "kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform", "junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
