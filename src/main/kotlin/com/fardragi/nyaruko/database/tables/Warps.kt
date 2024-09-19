package com.fardragi.nyaruko.database.tables

import org.jetbrains.exposed.dao.id.IdTable

object Warps : IdTable<UInt>("warps") {
    override val id = uinteger("id").autoIncrement().entityId()
    val name = varchar("name", 255).uniqueIndex()
    val dimension = integer("dimension")
    val positionX = integer("position_x")
    val positionY = integer("position_y")
    val positionZ = integer("position_z")

    override val primaryKey = PrimaryKey(id)
}
