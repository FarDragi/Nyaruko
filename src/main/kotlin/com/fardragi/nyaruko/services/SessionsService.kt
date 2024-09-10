package com.fardragi.nyaruko.services

import com.fardragi.nyaruko.viewmodels.PlayerInfoViewModel
import java.util.UUID

class SessionsService {
    private val authUsers = mutableMapOf<UUID, PlayerInfoViewModel>()

    fun loggedIn(userId: UUID, name: String): Boolean {
        if (userId in authUsers) {
            return false
        }

        authUsers[userId] = PlayerInfoViewModel(name)
        return true
    }

    fun loggedOut(userId: UUID): Boolean {
        if (userId !in authUsers) {
            return false
        }

        authUsers.remove(userId)
        return true
    }

    fun isLoggedIn(userId: UUID): Boolean {
        return userId in authUsers
    }
}
