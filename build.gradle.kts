import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.5.0"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  id("com.github.node-gradle.node") version "3.1.0"
  kotlin("jvm") version "1.5.10"
  kotlin("plugin.spring") version "1.5.10"
  kotlin("plugin.allopen") version "1.4.32"
  kotlin("plugin.jpa") version "1.5.20-RC"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.postgresql:postgresql:42.2.21")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("junit:junit:4.13")
  testImplementation("org.testcontainers:postgresql:1.15.3")
}

allOpen {
  annotation("javax.persistence.Entity")
  annotation("javax.persistence.Embeddable")
  annotation("javax.persistence.MappedSuperclass")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "1.8"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}

node {
  nodeProjectDir.set(file("${project.projectDir}/src/main/js"))
}

tasks.named("yarn_build") {
  dependsOn("yarn_install")
}

tasks.named("build") {
  dependsOn("yarn_build")
}

tasks.register<Exec>("integration") {
  environment("BUNDLE_GEMFILE", "src/test/integration/Gemfile")
  commandLine("bundle", "exec", "rspec", "src/test/integration/spec")
}
