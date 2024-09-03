package com.fardragi.dragiutils.database

import com.fardragi.dragiutils.config.DatabaseConfig
import com.fardragi.dragiutils.database.tables.Users
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf

class Database(config: DatabaseConfig) {
    private val connection: Database = Database.connect(
        url = "jdbc:mariadb://${config.host}:${config.port}/${config.name}",
        driver = "org.mariadb.jdbc.Driver",
        user = config.user,
        password = config.password
    )

    val users get() = connection.sequenceOf(Users)
}
