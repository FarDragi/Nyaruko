package com.fardragi.dragiutils.database

import com.fardragi.dragiutils.config.DatabaseConfig
import com.fardragi.dragiutils.database.tables.UsersTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils

class DatabaseConnection(config: DatabaseConfig) {
    init {
        Database.connect(
            url = "jdbc:mariadb://${config.host}:${config.port}/${config.name}",
            driver = "org.mariadb.jdbc.Driver",
            user = config.user,
            password = config.password
        )

        query {
            SchemaUtils.createMissingTablesAndColumns(UsersTable)
        }
    }
}
