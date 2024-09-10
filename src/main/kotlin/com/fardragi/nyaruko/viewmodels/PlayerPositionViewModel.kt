package com.fardragi.nyaruko.viewmodels

import net.minecraft.entity.player.EntityPlayerMP
import kotlin.math.floor

data class PlayerPositionViewModel(val player: EntityPlayerMP) {
    val positionX = player.posX;
    val positionY = player.posY;
    val positionZ = player.posZ
    val rotationYaw = player.rotationYaw
    val rotationPitch = player.rotationPitch

    val block get() = BlockViewModel(floor(positionX).toInt(), floor(positionY).toInt(), floor(positionZ).toInt())
}
