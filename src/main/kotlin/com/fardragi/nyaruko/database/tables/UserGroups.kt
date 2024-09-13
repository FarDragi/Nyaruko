package com.fardragi.nyaruko.database.tables

import org.jetbrains.exposed.dao.id.IdTable

object UserGroups : IdTable<UInt>("user_groups") {
    override val id = uinteger("id").autoIncrement().entityId()
    val userId = reference("user_id", Users)
    val groupId = reference("group_id", Groups)

    override val primaryKey = PrimaryKey(id)

    init {
        uniqueIndex(userId, groupId)
    }
}
