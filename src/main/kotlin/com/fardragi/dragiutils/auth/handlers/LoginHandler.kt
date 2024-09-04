package com.fardragi.dragiutils.auth.handlers

import com.fardragi.dragiutils.services.UserService
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginHandler(private val userService: UserService) {
    @SubscribeEvent
    fun onPlayerJoin(event: PlayerLoggedInEvent) {
        val userId = event.player.uniqueID.toString()
        val userName = event.player.displayName

        CoroutineScope(Dispatchers.IO).launch {
            userService.getOrCreateUser(userId, userName)
            userService.setPassword(userId, "123456789")
        }
    }
}
