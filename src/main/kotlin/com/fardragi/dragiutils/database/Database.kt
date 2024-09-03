package com.fardragi.dragiutils.database

import com.fardragi.dragiutils.config.DatabaseConfig
import com.fardragi.dragiutils.database.tables.Users
import com.zaxxer.hikari.HikariDataSource
import org.ktorm.database.Database
import org.ktorm.entity.sequenceOf

class Database(config: DatabaseConfig) {
    private val connection: Database

    init {
//        val dataSource = BasicDataSource()
//        dataSource.url = "jdbc:mariadb://${config.host}:${config.port}/${config.name}"
//        dataSource.username = config.user
//        dataSource.password = config.password
//        dataSource.minIdle = 5
//        dataSource.maxIdle = 10
//        dataSource.maxTotal = 50

        val dataSource = HikariDataSource()
        dataSource.jdbcUrl = "jdbc:mariadb://${config.host}:${config.port}/${config.name}"
        dataSource.username = config.user
        dataSource.password = config.password

        connection = Database.connect(dataSource)
    }

    val users get() = connection.sequenceOf(Users)
}