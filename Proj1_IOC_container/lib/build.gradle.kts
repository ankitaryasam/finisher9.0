

plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {

implementation("org.springframework:spring-context-support:6.1.10")

}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

