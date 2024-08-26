package com.fardragi.dragiutils.database.dao

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.IdTable

abstract class StringEntityClass<E : StringEntity>(table: IdTable<String>) :
    EntityClass<String, E>(table)
