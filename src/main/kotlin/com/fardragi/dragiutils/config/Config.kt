package com.fardragi.dragiutils.config

import com.fardragi.dragiutils.utils.getWorkingDir
import java.io.File
import net.minecraftforge.common.config.Configuration

object Config {
  var database: DatabaseConfig? = null

  fun synchronizeConfiguration() {
    val configuration = Configuration(File(getWorkingDir(), "config.cfg"))

    database = DatabaseConfig(configuration)

    if (configuration.hasChanged()) {
      configuration.save()
    }
  }
}
