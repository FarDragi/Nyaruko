package com.fardragi.nyaruko.core.events

import com.fardragi.nyaruko.shared.events.NyarukoEvent
import com.fardragi.nyaruko.viewmodels.PositionViewModel
import cpw.mods.fml.common.eventhandler.Cancelable
import net.minecraft.entity.player.EntityPlayerMP

@Cancelable
data class PlayerMoveEvent(
    val player: EntityPlayerMP,
    val oldPosition: PositionViewModel,
    val newPosition: PositionViewModel
) : NyarukoEvent() {
}
