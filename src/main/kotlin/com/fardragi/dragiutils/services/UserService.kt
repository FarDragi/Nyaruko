package com.fardragi.dragiutils.services

import com.fardragi.dragiutils.models.User

class UserService() {
    fun getOrCreateUser(id: String, name: String): User {
        var user = User.findById(id)

        if (user == null) {
            user = User.new(id) {
                this.name = name
            }
        }

        return user
    }
}
