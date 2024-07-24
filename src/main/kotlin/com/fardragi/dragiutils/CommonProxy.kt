package com.fardragi.dragiutils

import com.fardragi.dragiutils.Config.synchronizeConfiguration
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent

open class CommonProxy {
  // preInit "Run before anything else. Read your config, create blocks, items, etc, and register
  // them with the
  // GameRegistry." (Remove if not needed)
  fun preInit(event: FMLPreInitializationEvent) {
    synchronizeConfiguration(event.suggestedConfigurationFile)

    DragiUtils.LOG.info(Config.greeting)
    DragiUtils.LOG.info("I am MyMod at version " + Tags.VERSION)
  }

  // load "Do your mod setup. Build whatever data structures you care about. Register recipes."
  // (Remove if not needed)
  fun init(event: FMLInitializationEvent?) {}

  // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if
  // not needed)
  fun postInit(event: FMLPostInitializationEvent?) {}

  // register server commands in this event handler (Remove if not needed)
  fun serverStarting(event: FMLServerStartingEvent?) {}
}
