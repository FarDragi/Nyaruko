package com.fardragi.nyaruko.modules.base.handlers

import cpw.mods.fml.common.FMLCommonHandler
import net.minecraftforge.common.MinecraftForge

abstract class NyarukoHandlerBase {
    fun register() {
        MinecraftForge.EVENT_BUS.register(this)
        FMLCommonHandler.instance().bus().register(this)
    }
}
