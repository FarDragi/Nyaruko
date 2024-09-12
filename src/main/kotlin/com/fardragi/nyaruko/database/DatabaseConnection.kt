package com.fardragi.nyaruko.database

import com.fardragi.nyaruko.config.DatabaseConfig
import com.fardragi.nyaruko.database.tables.Commands
import com.fardragi.nyaruko.database.tables.Users
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

        CoroutineScope(Dispatchers.IO).launch {
            query {
                SchemaUtils.createMissingTablesAndColumns(Users, Commands)
            }
        }
    }
}
