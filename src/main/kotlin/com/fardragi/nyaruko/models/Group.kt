package com.fardragi.nyaruko.models

import com.fardragi.nyaruko.database.tables.Groups
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Group(id: EntityID<UInt>) : Entity<UInt>(id) {
    companion object : EntityClass<UInt, Group>(Groups)

    var name by Groups.name
    var order by Groups.order
    var default by Groups.default
}
