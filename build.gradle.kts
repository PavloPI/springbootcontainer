group = "my.ppi"
version = "0.0.1"
description = "springbootcontainer"

java.sourceCompatibility = JavaVersion.VERSION_17

plugins {
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.spring") version "1.9.0"
    application
    id("maven-publish")
}

sourceSets.main {
    java.srcDirs("src/main/jvm")
}

application {
    // Define the main class for the application.
    mainClass.set("my.ppi.App")
}

val slf4jVersion = "1.7.26"

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
    }
    implementation ("org.springframework.boot:spring-boot-starter-jetty")

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.2")

    implementation("org.glassfish.jaxb:jaxb-runtime:2.3.2")

    implementation("org.slf4j:slf4j-api:$slf4jVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
}

repositories {
    mavenLocal()
    mavenCentral()
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["kotlin"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}