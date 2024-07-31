package com.fardragi.dragiutils.database.models

import org.jetbrains.exposed.dao.id.IntIdTable

object User : IntIdTable() {
  val name = varchar("name", 255).uniqueIndex()
  val passwordHash = varchar("passwordHash", 255)
}
