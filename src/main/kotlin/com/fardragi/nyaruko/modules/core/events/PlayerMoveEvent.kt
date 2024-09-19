package com.fardragi.nyaruko.modules.core.events

import com.fardragi.nyaruko.modules.base.events.NyarukoEvent
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
