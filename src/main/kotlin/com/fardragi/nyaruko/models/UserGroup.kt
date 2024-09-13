package com.fardragi.nyaruko.models

import com.fardragi.nyaruko.database.tables.UserGroups
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserGroup(id: EntityID<UInt>) : Entity<UInt>(id) {
    companion object : EntityClass<UInt, UserGroup>(UserGroups)

    var userId by UserGroups.userId
    var groupId by UserGroups.groupId
    var user by User referencedOn UserGroups.userId
    var group by Group referencedOn UserGroups.groupId
}
