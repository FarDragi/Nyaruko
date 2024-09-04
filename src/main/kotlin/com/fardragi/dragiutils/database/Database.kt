package com.fardragi.dragiutils.database

import com.fardragi.dragiutils.config.DatabaseConfig
import com.fardragi.dragiutils.database.tables.UsersTable
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils

class Database(config: DatabaseConfig) {
    private val connection: Database

    init {
        val hikariConfig = HikariConfig().apply {
            jdbcUrl = "jdbc:mariadb://${config.host}:${config.port}/${config.name}"
            username = config.user
            password = config.password
            minimumIdle = 5
            maximumPoolSize = 50
        }

        val dataSource = HikariDataSource(hikariConfig)

        connection = Database.connect(dataSource)

        query {
            SchemaUtils.createMissingTablesAndColumns(UsersTable)
        }
    }
}
