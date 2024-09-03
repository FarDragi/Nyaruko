package com.fardragi.dragiutils.services

import com.fardragi.dragiutils.database.Database
import com.fardragi.dragiutils.database.tables.Users
import com.fardragi.dragiutils.models.User
import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.find

class UserService(private val database: Database) {
    fun getOrCreateUser(id: String, name: String): User {
        var user = database.users.find { Users.id eq id }

        if (user == null) {
            user = User() {
                this.id = id
                this.name = name
            }

            database.users.add(user)
        }

        return user
    }
}
