package com.fardragi.nyaruko.shared

import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent

interface IProxy {
    fun onPreInit(event: FMLPreInitializationEvent){
        return
    }
    fun onInit(event: FMLInitializationEvent){
        return
    }
    fun onPostInit(event: FMLPostInitializationEvent){
        return
    }
    fun onServerStarting(event: FMLServerStartingEvent){
        return
    }
}
