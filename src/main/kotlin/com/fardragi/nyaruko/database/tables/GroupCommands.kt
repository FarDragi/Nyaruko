package com.fardragi.nyaruko.database.tables

import org.jetbrains.exposed.dao.id.IdTable

object GroupCommands : IdTable<UInt>("group_commands") {
    override val id = uinteger("id").autoIncrement().entityId()
    val groupId = reference("group_id", Groups)
    val command = reference("command_id", Commands)
    val permission = bool("permission").default(true)

    override val primaryKey = PrimaryKey(id)

    init {
        uniqueIndex(groupId, command)
    }
}
