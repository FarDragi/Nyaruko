package com.fardragi.nyaruko.database.tables

import org.jetbrains.exposed.dao.id.IdTable

object UsersTable : IdTable<String>("users") {
    override val id = varchar("id", 36).entityId()
    val name = varchar("name", 50)
    val hash = varchar("hash", 128).nullable()

    override val primaryKey = PrimaryKey(id)
}
