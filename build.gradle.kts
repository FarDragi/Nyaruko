plugins {
  id ("com.gtnewhorizons.gtnhconvention")
  id ("org.jetbrains.kotlin.jvm")
}

tasks.register("copyJar") {
  group = "fardragi"
  dependsOn("build")
  doLast() {
    val target = File("C:\\Users\\mrvul\\Documents\\Minecraft\\FarDragiServer\\mods\\dragiutils.jar")
    val jar = File("./build/libs").walk().find { it.name.endsWith("dirty.jar") }

    jar?.copyTo(target, overwrite = true)
  }
}

tasks.register<Exec>("startServer") {
  group = "fardragi"
  standardInput = System.`in`
  dependsOn("copyJar")
  workingDir("C:\\Users\\mrvul\\Documents\\Minecraft\\FarDragiServer")
  commandLine("cmd", "/c", "startserver-java9.bat")
}
