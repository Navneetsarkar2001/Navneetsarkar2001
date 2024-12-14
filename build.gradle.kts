plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.redisson:redisson:3.22.0")
    implementation("io.lettuce:lettuce-core:6.5.1.RELEASE")
    implementation("org.postgresql:postgresql:42.7.2")
}

tasks.test {
    useJUnitPlatform()
}