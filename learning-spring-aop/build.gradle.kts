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
    // spring aop
    implementation("org.springframework:spring-aop:6.2.12")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}