package com.fardragi.nyaruko.services

import com.fardragi.nyaruko.exceptions.NotFoundException
import com.fardragi.nyaruko.viewmodels.PlayerInfoViewModel
import com.fardragi.nyaruko.viewmodels.PositionViewModel
import java.util.UUID

class SessionsService {
    private val authUsers = mutableMapOf<UUID, PlayerInfoViewModel>()

    fun loggedIn(userId: UUID, name: String, initialPosition: PositionViewModel): Boolean {
        if (userId in authUsers) {
            return false
        }

        authUsers[userId] = PlayerInfoViewModel(name, initialPosition)
        return true
    }

    fun loggedOut(userId: UUID): Boolean {
        if (userId !in authUsers) {
            return false
        }

        authUsers.remove(userId)
        return true
    }

    fun setAuthenticate(userId: UUID){
        val playerInfo = authUsers[userId]
            ?: throw NotFoundException(PlayerInfoViewModel::class.simpleName, userId.toString())

        playerInfo.authenticated = true

    }

    fun isAuthenticated(userId: UUID): Boolean {
        val playerInfo = authUsers[userId]
            ?: throw NotFoundException(PlayerInfoViewModel::class.simpleName, userId.toString())

        return playerInfo.authenticated
    }
}
