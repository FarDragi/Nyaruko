package com.fardragi.dragiutils.auth.handlers

import com.fardragi.dragiutils.services.UserService
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent

class LoginHandler(private val userService: UserService) {
    @SubscribeEvent
    fun onPlayerJoin(event: PlayerLoggedInEvent) {
        val userId = event.player.uniqueID.toString()
        val userName = event.player.displayName

        userService.getOrCreateUser(userId, userName)
    }
}
