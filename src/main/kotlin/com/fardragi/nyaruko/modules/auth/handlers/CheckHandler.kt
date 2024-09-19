package com.fardragi.nyaruko.modules.auth.handlers

import com.fardragi.nyaruko.modules.auth.messages.LoginMessage
import com.fardragi.nyaruko.modules.core.events.PlayerMoveEvent
import com.fardragi.nyaruko.extensions.isTruePlayer
import com.fardragi.nyaruko.extensions.sendMessages
import com.fardragi.nyaruko.services.SessionsService
import com.fardragi.nyaruko.modules.base.handlers.NyarukoHandlerBase
import cpw.mods.fml.common.eventhandler.EventPriority
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import net.minecraftforge.event.entity.item.ItemTossEvent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CheckHandler() : NyarukoHandlerBase(), KoinComponent {
    private val sessionsService: SessionsService by inject()

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun onPlayerMove(event: PlayerMoveEvent) {
        if (sessionsService.isAuthenticated(event.player.uniqueID) || !event.player.isTruePlayer())
            return

        event.player.sendMessages(LoginMessage.loginBeforeGaming())
        event.isCanceled = true
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun onDropItem(event: ItemTossEvent) {
        if (sessionsService.isAuthenticated(event.player.uniqueID) || !event.player.isTruePlayer())
            return

        event.player.sendMessages(LoginMessage.loginBeforeGaming())
        event.isCanceled = true

        val stack = event.entityItem.entityItem
        event.player.inventory.addItemStackToInventory(stack)
    }
}
