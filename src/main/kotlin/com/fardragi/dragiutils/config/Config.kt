package com.fardragi.dragiutils.config

import com.fardragi.dragiutils.exceptions.DragiUtilsException
import com.fardragi.dragiutils.utils.getWorkingDir
import java.io.File
import net.minecraftforge.common.config.Configuration

object Config {
  private var _module: ModuleConfig? = null
  private var _database: DatabaseConfig? = null

  fun synchronizeConfiguration() {
    val configuration = Configuration(File(getWorkingDir(), "config.cfg"))

    _module = ModuleConfig(configuration)
    _database = DatabaseConfig(configuration)

    if (configuration.hasChanged()) {
      configuration.save()
    }
  }

  val module: ModuleConfig
    get() = _module ?: throw DragiUtilsException("Fail get module config")
  val database: DatabaseConfig
    get() = _database ?: throw DragiUtilsException("Fail get database config")
}
