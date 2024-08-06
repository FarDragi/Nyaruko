package com.fardragi.dragiutils.database

import com.fardragi.dragiutils.config.DatabaseConfig
import com.fardragi.dragiutils.database.models.User
import cpw.mods.fml.common.FMLLog
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseModule(databaseConfig: DatabaseConfig) {
  init {
    val connectionString =
        "jdbc:mariadb://${databaseConfig.host}:${databaseConfig.port}/${databaseConfig.database}"

    try {
      Database.connect(
          connectionString,
          driver = "org.mariadb.jdbc.Driver",
          user = databaseConfig.user,
          password = databaseConfig.password,
      )

      transaction { SchemaUtils.createMissingTablesAndColumns(User) }
    } catch (ex: Exception) {
      FMLLog.severe(ex.message)
    }
  }
}
