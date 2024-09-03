package com.fardragi.dragiutils.models

import org.ktorm.entity.Entity

interface User : Entity<User> {
    companion object : Entity.Factory<User>()

    var id: String
    var name: String
    var hash: String?
    var salt: String?

    val isRegistered get() = hash != null && salt != null
}
