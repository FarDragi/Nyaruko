package com.fardragi.nyaruko.viewmodels

import com.fardragi.nyaruko.models.Warp
import net.minecraft.entity.Entity
import kotlin.math.floor

class PositionViewModel {
    val dimension: Int
    val positionX: Double
    val positionY: Double
    val positionZ: Double
    val rotationYaw: Float
    val rotationPitch: Float

    constructor(player: Entity) {
        dimension = player.dimension
        positionX = player.posX
        positionY = player.posY
        positionZ = player.posZ
        rotationYaw = player.rotationYaw
        rotationPitch = player.rotationPitch
    }

    constructor(player: Entity, warp: Warp) {
        dimension = warp.dimension
        positionX = warp.positionX.toDouble()
        positionY = warp.positionY.toDouble()
        positionZ = warp.positionZ.toDouble()
        rotationYaw = player.rotationYaw
        rotationPitch = player.rotationPitch
    }

    val block
        get() = BlockViewModel(
            dimension,
            floor(positionX).toInt(),
            floor(positionY).toInt(),
            floor(positionZ).toInt()
        )
}
