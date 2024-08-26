package com.fardragi.dragiutils.server

import com.fardragi.dragiutils.DragiUtils
import com.fardragi.dragiutils.Tags
import com.fardragi.dragiutils.auth.AuthModule
import com.fardragi.dragiutils.config.Config
import com.fardragi.dragiutils.config.Config.synchronizeConfiguration
import com.fardragi.dragiutils.database.DatabaseModule
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent

open class ServerProxy {
  fun preInit(event: FMLPreInitializationEvent) {
    synchronizeConfiguration()

    DragiUtils.log.info("DragiUtils " + Tags.VERSION)
  }

  fun init(event: FMLInitializationEvent?) {
    DatabaseModule(Config.database)

    if (Config.module.auth) {
      AuthModule()
    }
  }

  fun postInit(event: FMLPostInitializationEvent?) {}

  fun serverStarting(event: FMLServerStartingEvent?) {}
}
