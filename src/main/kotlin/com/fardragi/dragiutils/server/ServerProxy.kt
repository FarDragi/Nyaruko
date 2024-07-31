package com.fardragi.dragiutils.server

import com.fardragi.dragiutils.DragiUtils
import com.fardragi.dragiutils.Tags
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

    DragiUtils.LOG.info(Config.database?.host)
    DragiUtils.LOG.info("I am MyMod at version " + Tags.VERSION)
  }

  fun init(event: FMLInitializationEvent?) {
    Config.database?.let { DatabaseModule(it) }
  }

  fun postInit(event: FMLPostInitializationEvent?) {}

  fun serverStarting(event: FMLServerStartingEvent?) {}
}
