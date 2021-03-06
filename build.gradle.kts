
/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 */

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    kotlin("jvm") version "1.4.0"
    idea
    // Apply the application plugin to add support for building a CLI application.
    application
    id("com.github.johnrengelman.shadow") version "5.2.0"

 //   id("com.palantir.git-version") version "0.12.2"
}

repositories {
    // Use jcenter for resolving dependencies.
    jcenter()

    maven("https://oss.sonatype.org/content/repositories/snapshots")

}



dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")


    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")


    // eclipse lsp implementation
    implementation("org.eclipse.lsp4j", "org.eclipse.lsp4j",  "0.9.0")

    // json converter
    implementation("com.google.code.gson" ,"gson" ,"2.8.6")


    // https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-test-junit5
    testImplementation(kotlin("test-junit5"))

    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
    testImplementation("org.junit.jupiter","junit-jupiter-engine" ,  "5.7.0-M1")

    implementation("de.hhu.stups:de.prob2.kernel:4.0.0-SNAPSHOT")

    implementation( "com.google.guava", "guava", "28.2-jre")


    // https://mvnrepository.com/artifact/org.zeromq/jeromq
    implementation ("org.zeromq",   "jeromq", "0.5.2")


}





tasks.test {
    useJUnitPlatform()
}

val gitVersion: groovy.lang.Closure<*> by extra

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>(){
    kotlinOptions.jvmTarget = "1.8"
}


tasks.shadowJar{
  //  this.version = gitVersion().toString()
}


application {
    // Define the main class for the application.
    mainClassName = "b.language.server.AppKt"
}
