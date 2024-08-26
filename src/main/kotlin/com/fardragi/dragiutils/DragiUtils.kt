package com.fardragi.dragiutils

import com.fardragi.dragiutils.exceptions.DragiUtilsException
import com.fardragi.dragiutils.server.ServerProxy
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
    acceptedMinecraftVersions = "[1.7.10]",
    acceptableRemoteVersions = "*")
class DragiUtils {
  @Mod.EventHandler
  fun preInit(event: FMLPreInitializationEvent) {
    proxy.preInit(event)
  }

  @Mod.EventHandler
  fun init(event: FMLInitializationEvent?) {
    proxy.init(event)
  }

  @Mod.EventHandler
  fun postInit(event: FMLPostInitializationEvent?) {
    proxy.postInit(event)
  }

  @Mod.EventHandler
  fun serverStarting(event: FMLServerStartingEvent?) {
    proxy.serverStarting(event)
  }

  companion object {
    const val MODID: String = "dragiutils"

    @SidedProxy(
        clientSide = "com.fardragi.dragiutils.client.ClientProxy",
        serverSide = "com.fardragi.dragiutils.server.ServerProxy")
    private var _proxy: ServerProxy? = null

    val log: Logger = LogManager.getLogger(MODID)
    val proxy: ServerProxy
      get() = _proxy ?: throw DragiUtilsException("Fail get proxy")
  }
}
