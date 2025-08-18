plugins {
    id("java")
}

group = "com.su8y"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.junit:junit-bom:5.10.0"))
    implementation("org.junit.jupiter:junit-jupiter")

}

tasks.test {
    useJUnitPlatform()
}