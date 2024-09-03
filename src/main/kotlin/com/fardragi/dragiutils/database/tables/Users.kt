package com.fardragi.dragiutils.database.tables

import com.fardragi.dragiutils.models.User
import org.ktorm.schema.Table
import org.ktorm.schema.varchar

object Users : Table<User>("users"){
    val id = varchar("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
}
