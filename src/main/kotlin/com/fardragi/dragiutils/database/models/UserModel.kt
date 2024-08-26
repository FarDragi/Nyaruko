package com.fardragi.dragiutils.database.models

import com.fardragi.dragiutils.database.tables.UsersTable
import com.fardragi.dragiutils.utils.Password
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserModel(id: EntityID<Int>) : IntEntity(id) {
  companion object : IntEntityClass<UserModel>(UsersTable)
  private var hash by UsersTable.hash
  private var salt by UsersTable.salt

  fun setPassword(password: String) {
    val (hash, salt) = Password.genPassword(password)
    this.hash = hash
    this.salt = salt
  }

  fun checkPassword(password: String): Boolean {
    return Password.checkPassword(password, hash, salt)
  }
}
