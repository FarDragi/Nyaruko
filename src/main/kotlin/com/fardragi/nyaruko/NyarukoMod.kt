package com.fardragi.nyaruko

import com.fardragi.nyaruko.modules.base.IProxy
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
object NyarukoMod {
    @SidedProxy(serverSide = "$GROUPNAME.server.ServerProxy", clientSide = "$GROUPNAME.client.ClientProxy")
    lateinit var proxy: IProxy

    @Mod.EventHandler
    @Suppress("UNUSED")
    fun onPreInit(event: FMLPreInitializationEvent) {
        proxy.onPreInit(event)
    }

    @Mod.EventHandler
    @Suppress("UNUSED")
    fun onInit(event: FMLInitializationEvent) {
        proxy.onInit(event)
    }

    @Mod.EventHandler
    @Suppress("UNUSED")
    fun onPostInit(event: FMLPostInitializationEvent) {
        proxy.onPostInit(event)
    }

    @Mod.EventHandler
    @Suppress("UNUSED")
    fun onServerStarting(event: FMLServerStartingEvent) {
        proxy.onServerStarting(event)
    }
}
