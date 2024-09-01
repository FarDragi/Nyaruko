package com.fardragi.dragiutils

import com.fardragi.dragiutils.proxy.CommonProxy
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent

@Mod(
    modid = MODID,
    name = MODNAME,
    version = VERSION,
    modLanguageAdapter = "net.shadowfacts.forgelin.KotlinAdapter",
    dependencies = "required-after:forgelin",
    acceptedMinecraftVersions = "[1.7.10]",
    acceptableRemoteVersions = "*"
)
object DragiUtils {
    @SidedProxy(serverSide = "$GROUPNAME.proxy.CommonProxy", clientSide = "$GROUPNAME.proxy.ClientProxy")
    lateinit var proxy: CommonProxy

    @Mod.EventHandler
    fun onPreInit(event: FMLPreInitializationEvent) {
        proxy.onPreInit(event)
    }

    @Mod.EventHandler
    fun onInit(event: FMLInitializationEvent) {
        proxy.onInit(event)
    }

    @Mod.EventHandler
    fun onPostInit(event: FMLPostInitializationEvent) {
        proxy.onPostInit(event)
    }

    @Mod.EventHandler
    fun onServerStarting(event: FMLServerStartingEvent) {
        proxy.onServerStarting(event)
    }
}
