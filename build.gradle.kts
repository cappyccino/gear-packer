import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.5.0"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  id("application")
  id("com.github.node-gradle.node") version "3.1.0"
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
  implementation("org.springframework.boot:spring-boot-starter-actuator:2.6.2")
  implementation("org.springframework.boot:spring-boot-starter-web:2.6.2")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.2")
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
//  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.postgresql:postgresql:42.3.1")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")

  testImplementation("org.springframework.boot:spring-boot-starter-test:2.6.2")
//  testImplementation("org.springframework.security:spring-security-test")
  testImplementation("org.testcontainers:postgresql:1.16.2")
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

tasks.register<Copy>("copyStaticJSResources") {
  description = "Copies all static resources for the JS app into the SpringBoot dir"
  mustRunAfter("yarn_build")

  from(layout.projectDirectory.dir("js/static/"))
  into(layout.projectDirectory.dir("src/main/resources/static"))
  // TODO future - this is hacky, but Thymeleaf only seems to recognize templates
  // if they're present before the build. Will look into later
}

tasks.named("yarn_build") {
  mustRunAfter("yarn_install")
}

tasks.register("buildApp") {
  description = "Builds the SpringBoot app with the JS app"
  dependsOn("yarn_install", "yarn_build", "copyStaticJSResources")
  finalizedBy("build")
}

tasks.register("bootRunApp") {
  description = "Builds the SpringBoot app with the JS app"
  dependsOn("yarn_build", "copyStaticJSResources")
  finalizedBy("bootRun")
}
