package com.fardragi.dragiutils.database.dao

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.id.EntityID

abstract class StringEntity(id: EntityID<String>) : Entity<String>(id)
