package com.fardragi.nyaruko.models

import com.fardragi.nyaruko.database.tables.UsersTable
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder

class User(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, User>(UsersTable)

    var name by UsersTable.name
    private var hash by UsersTable.hash

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


