package com.fardragi.dragiutils.database.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
class User {
    @Id
    @Column(nullable = false)
    var id: String = ""

    @Column(nullable = false)
    var name: String = ""
}
