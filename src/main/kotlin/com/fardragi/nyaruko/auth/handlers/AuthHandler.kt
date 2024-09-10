package com.fardragi.nyaruko.auth.handlers

import com.fardragi.nyaruko.auth.messages.WelcomeMessage
import com.fardragi.nyaruko.config.DiscordConfig
import com.fardragi.nyaruko.extensions.sendMessages
import com.fardragi.nyaruko.services.SessionsService
import com.fardragi.nyaruko.services.UserService
import com.fardragi.nyaruko.shared.handlers.NyarukoHandlerBase
import cpw.mods.fml.common.eventhandler.EventPriority
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AuthHandler(
    private val userService: UserService,
    private val discordConfig: DiscordConfig,
    private val sessionsService: SessionsService
) : NyarukoHandlerBase() {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onPlayerJoin(event: PlayerLoggedInEvent) {
        val player = event.player
        val userId = player.uniqueID
        val userName = player.displayName

        CoroutineScope(Dispatchers.IO).launch {
            val user = userService.getOrCreateUser(userId, userName)

            delay(2000)

            val welcome = WelcomeMessage.create(user.isRegistered, discordConfig.discordInvite)
            player.sendMessages(welcome)
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onPlayerLeave(event: PlayerLoggedOutEvent) {
        val player = event.player
        val userId = player.uniqueID

        sessionsService.loggedOut(userId)
    }
}
