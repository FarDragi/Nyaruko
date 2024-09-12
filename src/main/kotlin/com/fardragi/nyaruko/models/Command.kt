package com.fardragi.nyaruko.models

import com.fardragi.nyaruko.database.tables.Commands
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Command(id: EntityID<UInt>) : Entity<UInt>(id) {
    companion object : EntityClass<UInt, Command>(Commands)

    var name by Commands.name
    var level by Commands.level
}
