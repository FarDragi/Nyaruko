package com.fardragi.nyaruko.models

import com.fardragi.nyaruko.database.tables.Users
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import java.util.UUID

class User(id: EntityID<UUID>) : Entity<UUID>(id) {
    companion object : EntityClass<UUID, User>(Users)

    var name by Users.name
    private var hash by Users.hash

    val isRegistered get() = hash != null

    fun updatePassword(password: String) {
        hash = createEncoder().encode(password)
    }

    fun checkPassword(password: String): Boolean {
        return createEncoder().matches(password, hash)
    }

    private fun createEncoder(): Argon2PasswordEncoder {
        return Argon2PasswordEncoder(
            16, 32, 2, 1024 * 64, 10
        )
    }
}
