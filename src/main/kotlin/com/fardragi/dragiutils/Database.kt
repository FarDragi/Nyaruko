package com.fardragi.dragiutils

import org.hibernate.cfg.Configuration
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

object Database {
    val sessionFactory = Configuration().configure().buildSessionFactory()
}

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0

    @Column(length = 50)
    var name: String = ""
}
