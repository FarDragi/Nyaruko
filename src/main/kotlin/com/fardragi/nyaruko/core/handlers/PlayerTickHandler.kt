package com.fardragi.nyaruko.core.handlers

import com.fardragi.nyaruko.core.events.PlayerMoveEvent
import com.fardragi.nyaruko.extensions.teleport
import com.fardragi.nyaruko.shared.handlers.NyarukoHandlerBase
import com.fardragi.nyaruko.viewmodels.PositionViewModel
import cpw.mods.fml.common.eventhandler.EventPriority
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent
import cpw.mods.fml.common.gameevent.TickEvent
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent
import net.minecraft.entity.player.EntityPlayerMP
import java.util.UUID

class PlayerTickHandler : NyarukoHandlerBase() {
    private val playerPositions = mutableMapOf<UUID, PositionViewModel>()

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun onPlayerTick(event: PlayerTickEvent) {
        if (event.phase != TickEvent.Phase.START)
            return

        val player = event.player as EntityPlayerMP

        if (player.uniqueID !in playerPositions) {
            playerPositions[player.uniqueID] = PositionViewModel(player)
            return
        }

        playerPositions[player.uniqueID]?.let { oldPosition ->
            val newPosition = PositionViewModel(player)

            if (oldPosition.block != newPosition.block) {
                playerPositions[player.uniqueID] = newPosition

                val playerMoveEvent = PlayerMoveEvent(player, oldPosition, newPosition)
                playerMoveEvent.send()

                if (playerMoveEvent.isCanceled) {
                    player.teleport(oldPosition)
                    playerPositions[player.uniqueID] = oldPosition
                }
            } else {
                playerPositions[player.uniqueID] = newPosition
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    fun onPlayerLoggedOut(event: PlayerLoggedOutEvent) {
        if (event.player !is EntityPlayerMP) {
            return
        }

        playerPositions.remove(event.player.uniqueID)
    }
}
