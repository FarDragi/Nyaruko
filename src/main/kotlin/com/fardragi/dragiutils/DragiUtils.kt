package com.fardragi.dragiutils

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(
    modid = DragiUtils.MODID,
    version = Tags.VERSION,
    name = "DragiUtils",
    acceptedMinecraftVersions = "[1.7.10]")
class DragiUtils {
  @Mod.EventHandler // preInit "Run before anything else. Read your config, create blocks, items,
  // etc, and register them with the
  // GameRegistry." (Remove if not needed)
  fun preInit(event: FMLPreInitializationEvent) {
    proxy!!.preInit(event)
  }

  @Mod.EventHandler // load "Do your mod setup. Build whatever data structures you care about.
  // Register recipes." (Remove if not needed)
  fun init(event: FMLInitializationEvent?) {
    proxy!!.init(event)
  }

  @Mod.EventHandler // postInit "Handle interaction with other mods, complete your setup based on
  // this." (Remove if not needed)
  fun postInit(event: FMLPostInitializationEvent?) {
    proxy!!.postInit(event)
  }

  @Mod.EventHandler // register server commands in this event handler (Remove if not needed)
  fun serverStarting(event: FMLServerStartingEvent?) {
    proxy!!.serverStarting(event)
  }

  companion object {
    const val MODID: String = "dragiutils"
    @JvmField val LOG: Logger = LogManager.getLogger(MODID)

    @SidedProxy(
        clientSide = "com.fardragi.dragiutils.ClientProxy",
        serverSide = "com.fardragi.dragiutils.CommonProxy")
    var proxy: CommonProxy? = null
  }
}
