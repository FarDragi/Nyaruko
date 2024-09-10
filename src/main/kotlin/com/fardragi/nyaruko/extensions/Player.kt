package com.fardragi.nyaruko.extensions

import com.fardragi.nyaruko.viewmodels.PlayerPositionViewModel
import net.minecraft.entity.player.EntityPlayerMP

fun EntityPlayerMP.teleportTo(position: PlayerPositionViewModel) {
    this.playerNetServerHandler.setPlayerLocation(
        position.positionX,
        position.positionY,
        position.positionZ,
        position.rotationYaw,
        position.rotationPitch
    )
}
