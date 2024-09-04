package com.fardragi.dragiutils.database.tables

import org.jetbrains.exposed.dao.id.IdTable

object UsersTable : IdTable<String>("users") {
    override val id = varchar("id", 36).entityId()
    val name = varchar("name", 50)
    val hash = varchar("hash", 32).nullable()
    val salt = varchar("salt", 32).nullable()

    override val primaryKey = PrimaryKey(id)
}
