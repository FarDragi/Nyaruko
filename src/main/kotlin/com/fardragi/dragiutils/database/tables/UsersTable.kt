package com.fardragi.dragiutils.database.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object UsersTable : IntIdTable("users") {
  val hash = binary("hash", 32)
  val salt = binary("salt", 16)
}
