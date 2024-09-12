package com.fardragi.nyaruko.auth.handlers

import com.fardragi.nyaruko.auth.messages.WelcomeMessage
import com.fardragi.nyaruko.config.DiscordConfig
import com.fardragi.nyaruko.extensions.sendMessages
import com.fardragi.nyaruko.services.SessionsService
import com.fardragi.nyaruko.services.UserService
import com.fardragi.nyaruko.shared.handlers.NyarukoHandlerBase
import com.fardragi.nyaruko.viewmodels.PositionViewModel
import cpw.mods.fml.common.eventhandler.EventPriority
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthHandler() : NyarukoHandlerBase(), KoinComponent {
    private val userService: UserService by inject()
    private val discordConfig: DiscordConfig by inject()
    private val sessionsService: SessionsService by inject()

    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onPlayerJoin(event: PlayerLoggedInEvent) {
        val player = event.player
        val userId = player.uniqueID
        val userName = player.displayName

        CoroutineScope(Dispatchers.IO).launch {
            val user = userService.getOrCreateUser(userId, userName)
            sessionsService.loggedIn(userId, userName, PositionViewModel(player))

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
