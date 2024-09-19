package com.fardragi.nyaruko.database

import com.fardragi.nyaruko.config.DatabaseConfig
import com.fardragi.nyaruko.database.tables.*
import kotlinx.coroutines.runBlocking
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

        runBlocking {
            query {
                SchemaUtils.createMissingTablesAndColumns(
                    Users, Commands, Groups, UserGroups, GroupCommands, Warps
                )
            }
        }
    }
}
