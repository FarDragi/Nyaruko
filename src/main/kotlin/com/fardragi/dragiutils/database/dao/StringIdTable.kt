package com.fardragi.dragiutils.database.dao

import org.jetbrains.exposed.dao.id.IdTable

open class StringIdTable(name: String = "", idColumnSize: Int = 32, idColumnName: String = "id") :
    IdTable<String>(name) {
  override val id = varchar(idColumnName, idColumnSize).entityId()
}
