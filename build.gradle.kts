plugins {
    id("com.gtnewhorizons.gtnhconvention")
    id("org.sonarqube") version "5.0.0.4638"
}

sonar {
    properties {
        property("sonar.projectKey", "DragiUtils")
        property("sonar.projectName", "DragiUtils")
    }
}
