package com.fardragi.nyaruko.auth.handlers

import com.fardragi.nyaruko.auth.messages.LoginMessage
import com.fardragi.nyaruko.auth.messages.RegisterMessage
import com.fardragi.nyaruko.services.UserService
import cpw.mods.fml.common.eventhandler.EventPriority
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginHandler(private val userService: UserService) {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun onPlayerJoin(event: PlayerLoggedInEvent) {
        val player = event.player
        val userId = player.uniqueID.toString()
        val userName = player.displayName

        CoroutineScope(Dispatchers.IO).launch {
            val user = userService.getOrCreateUser(userId, userName)

            delay(2000)

            val message = if (user.isRegistered)
                LoginMessage.create()
            else
                RegisterMessage.create()

            player.addChatMessage(message)
        }
    }
}
