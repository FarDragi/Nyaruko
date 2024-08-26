pluginManagement {
  repositories {
    maven("https://nexus.gtnewhorizons.com/repository/public/") {
      // RetroFuturaGradle
      name = "GTNH Maven"
      mavenContent {
        includeGroup("com.gtnewhorizons")
        includeGroupByRegex("com\\.gtnewhorizons\\..+")
      }
    }
    gradlePluginPortal()
    mavenCentral()
    mavenLocal()
  }
  plugins {
    kotlin("jvm") version "2.0.0"
  }
}

plugins {
  id("com.gtnewhorizons.gtnhsettingsconvention") version "1.0.26"
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
