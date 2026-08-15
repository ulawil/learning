plugins {
    id("java")
}

group = "com.uleczka"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // spring core
    implementation("org.springframework:spring-context:6.2.12")
    implementation("org.springframework:spring-web:7.0.8")
    // jakarta for @PostConstruct
    implementation("jakarta.annotation:jakarta.annotation-api:3.0.0")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

tasks.test {
    useJUnitPlatform()
}