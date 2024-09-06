package com.fardragi.nyaruko.services

import com.fardragi.nyaruko.database.query
import com.fardragi.nyaruko.exceptions.NotFoundException
import com.fardragi.nyaruko.models.User

class UserService() {
    suspend fun getOrCreateUser(id: String, name: String): User {
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

    suspend fun setPassword(id: String, password: String) {
        query {
            User.findByIdAndUpdate(id) { user ->
                user.updatePassword(password)
            } ?: throw NotFoundException("User not found")
        }
    }
}
