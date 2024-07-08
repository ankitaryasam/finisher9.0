/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java library project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.7/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
   // https://mvnrepository.com/artifact/org.springframework/spring-context-support
implementation("org.springframework:spring-context-support:6.1.10")
// https://mvnrepository.com/artifact/org.springframework/spring-jdbc
implementation("org.springframework:spring-jdbc:6.1.10")
// https://mvnrepository.com/artifact/org.springframework/spring-tx
implementation("org.springframework:spring-tx:6.1.10")
// https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
implementation("com.mysql:mysql-connector-j:8.0.33")

}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}


