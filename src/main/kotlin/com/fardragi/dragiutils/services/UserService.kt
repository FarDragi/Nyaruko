package com.fardragi.dragiutils.services

import com.fardragi.dragiutils.database.query
import com.fardragi.dragiutils.exceptions.NotFoundException
import com.fardragi.dragiutils.models.User

class UserService() {
    fun getOrCreateUser(id: String, name: String): User {
        return query {
            var user = User.findById(id)
            if (user == null) {
                user = User.new(id) {

                    this.name = name
                }
            }

            user
        }
    }

    fun setPassword(id: String, password: String) {
        query {
            User.findByIdAndUpdate(id) { user ->
                user.updatePassword(password)
            } ?: throw NotFoundException("User not found")
        }
    }
}
