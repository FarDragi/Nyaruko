package com.fardragi.dragiutils.proxy

import com.fardragi.dragiutils.DatabaseFoda
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent

open class CommonProxy {
    fun onPreInit(event: FMLPreInitializationEvent) {}
    fun onInit(event: FMLInitializationEvent) {
        DatabaseFoda()
    }
    fun onPostInit(event: FMLPostInitializationEvent) {}
    fun onServerStarting(event: FMLServerStartingEvent) {}
}
