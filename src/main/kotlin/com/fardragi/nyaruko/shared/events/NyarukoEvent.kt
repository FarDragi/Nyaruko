package com.fardragi.nyaruko.shared.events

import cpw.mods.fml.common.eventhandler.Event
import net.minecraftforge.common.MinecraftForge

open class NyarukoEvent : Event() {
    fun send() {
        MinecraftForge.EVENT_BUS.post(this)
    }
}
