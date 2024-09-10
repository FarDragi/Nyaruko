package com.fardragi.nyaruko.auth.handlers

import com.fardragi.nyaruko.core.events.PlayerMoveEvent
import com.fardragi.nyaruko.services.SessionsService
import com.fardragi.nyaruko.shared.handlers.NyarukoHandlerBase
import cpw.mods.fml.common.eventhandler.EventPriority
import cpw.mods.fml.common.eventhandler.SubscribeEvent

class CheckHandler(private val sessionsService: SessionsService) : NyarukoHandlerBase() {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun onPlayerMove(event: PlayerMoveEvent) {
        if (sessionsService.isLoggedIn(event.player.uniqueID)) {
            return
        }

        event.isCanceled = true
    }
}
