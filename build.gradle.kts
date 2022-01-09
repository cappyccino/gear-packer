import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.5.0"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.5.31"
  kotlin("plugin.spring") version "1.6.10"
  kotlin("plugin.jpa") version "1.5.20-RC"
}

group = "com.gearpacker"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator:2.5.6")
  implementation("org.springframework.boot:spring-boot-starter-web:2.5.6")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.2")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.postgresql:postgresql:42.3.1")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")

  testImplementation("org.testcontainers:postgresql:1.16.2")
  testImplementation("org.springframework.boot:spring-boot-starter-test:2.5.6")
  testImplementation("junit:junit:4.13.2")
}

tasks.withType<JavaCompile> {
  dependsOn(tasks.withType<ProcessResources>())
}

tasks.withType<KotlinCompile> {
  dependsOn(tasks.withType<ProcessResources>())
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "1.8"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.register<Exec>("integration") {
  environment("BUNDLE_GEMFILE", "src/test/integration/Gemfile")
  commandLine("bundle", "exec", "rspec", "src/test/integration/spec")
}
