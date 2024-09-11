package com.fardragi.nyaruko.utils

import net.minecraft.entity.Entity
import net.minecraft.world.Teleporter
import net.minecraft.world.WorldServer

class NyarukoTeleporter(
    worldIn: WorldServer,
    private val positionX: Double,
    private val positionY: Double,
    private val positionZ: Double,
    private val yaw: Float,
    private val pitch: Float
) :
    Teleporter(worldIn) {
    override fun placeInPortal(entity: Entity, x: Double, y: Double, z: Double, r: Float) {
        entity.setLocationAndAngles(positionX, positionY, positionZ, yaw, pitch)
    }

    override fun placeInExistingPortal(
        par1Entity: Entity?,
        par2: Double,
        par4: Double,
        par6: Double,
        par8: Float
    ): Boolean {
        return false
    }
}
