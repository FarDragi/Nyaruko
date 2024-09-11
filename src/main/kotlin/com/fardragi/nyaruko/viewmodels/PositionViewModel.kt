package com.fardragi.nyaruko.viewmodels

import net.minecraft.entity.Entity
import kotlin.math.floor

data class PositionViewModel(val player: Entity) {
    val dimension = player.dimension
    val positionX = player.posX
    val positionY = player.posY
    val positionZ = player.posZ
    val rotationYaw = player.rotationYaw
    val rotationPitch = player.rotationPitch

    val block
        get() = BlockViewModel(
            dimension,
            floor(positionX).toInt(),
            floor(positionY).toInt(),
            floor(positionZ).toInt()
        )
}
