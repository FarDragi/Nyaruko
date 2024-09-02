package com.fardragi.dragiutils.database.models

import org.ktorm.entity.Entity

interface User : Entity<User> {
    companion object : Entity.Factory<User>()

    var id: String
    var name: String
}
