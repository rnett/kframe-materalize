import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URL

plugins {
    java
    kotlin("jvm") version "1.2.70"
    `maven-publish`
    maven
}

group = "com.rnett.kframe-materalize"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/ktor")
    maven("https://jitpack.io")
}

fun getNewestCommit(gitURL: String, default: String = ""): String {
    return try {
        URL("https://api.github.com/repos/$gitURL/commits").readText()
                .substringAfter("\"sha\":\"").substringBefore("\",").substring(0, 10)
    } catch (e: Exception) {
        default
    }
}

val kframe_version = getNewestCommit("rnett/kframe", "ccf05c483e")

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
    implementation("com.github.rnett:kframe:$kframe_version")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
val sourcesJar by tasks.creating(Jar::class) {
    classifier = "sources"
    from(java.sourceSets["main"].allSource)
}

artifacts.add("archives", sourcesJar)

publishing {
    publications {
        create("default", MavenPublication::class.java) {
            from(components["java"])
            artifact(sourcesJar)
        }
        create("mavenJava", MavenPublication::class.java) {
            from(components["java"])
            artifact(sourcesJar)
        }
    }
    repositories {
        maven {
            url = uri("$buildDir/repository")
        }
    }
}