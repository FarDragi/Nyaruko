package com.fardragi.nyaruko.database.tables

import org.jetbrains.exposed.dao.id.IdTable
import java.util.UUID

object Users : IdTable<UUID>("users") {
    override val id = uuid("id").entityId()
    val name = varchar("name", 50)
    val hash = varchar("hash", 128).nullable()

    override val primaryKey = PrimaryKey(id)
}
