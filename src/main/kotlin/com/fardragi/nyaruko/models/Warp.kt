package com.fardragi.nyaruko.models

import com.fardragi.nyaruko.database.tables.Warps
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Warp(id: EntityID<UInt>) : Entity<UInt>(id) {
    companion object : EntityClass<UInt, Warp>(Warps)

    var name by Warps.name
    var dimension by Warps.dimension
    var positionX by Warps.positionX
    var positionY by Warps.positionY
    var positionZ by Warps.positionZ
}
