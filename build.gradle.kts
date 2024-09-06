plugins {
    id("com.gtnewhorizons.gtnhconvention")
    id("org.sonarqube") version "5.0.0.4638"
}

sonar {
    properties {
        property("sonar.projectKey", "Nyaruko")
        property("sonar.projectName", "Nyaruko")
    }
}

tasks.register("copyJar") {
    group = "fardragi"
    dependsOn("build")
    doLast() {
        val target = File("C:\\Users\\mrvul\\Documents\\Minecraft\\FarDragiServer\\mods\\nyaruko.jar")
        val jar = File("./build/libs").walk()
            .filter { it.isFile && it.name.endsWith(".jar") }
            .sortedByDescending { it.lastModified() }
            .take(4)
            .sortedBy { it.name }
            .last()

        jar.copyTo(target, overwrite = true)
    }
}

tasks.register<Exec>("startServer") {
    group = "fardragi"
    standardInput = System.`in`
    dependsOn("copyJar")
    workingDir("C:\\Users\\mrvul\\Documents\\Minecraft\\FarDragiServer")
    commandLine("cmd", "/c", "startserver-java9.bat")
}
