package com.fardragi.nyaruko.database.tables

import org.jetbrains.exposed.dao.id.IdTable

object Groups : IdTable<UInt>("groups") {
    override val id = uinteger("id").autoIncrement().entityId()
    val name = varchar("name", 255).uniqueIndex()
    val order = uinteger("order").uniqueIndex()
    val default = bool("default").uniqueIndex().default(false)

    override val primaryKey = PrimaryKey(id)
}
