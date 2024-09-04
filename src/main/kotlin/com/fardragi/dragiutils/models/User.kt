package com.fardragi.dragiutils.models

import com.fardragi.dragiutils.database.tables.UsersTable
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class User(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, User>(UsersTable)

    var name by UsersTable.name
    private var hash by UsersTable.hash
    private var salt by UsersTable.salt

    val isRegistered get() = hash != null && salt != null
}


