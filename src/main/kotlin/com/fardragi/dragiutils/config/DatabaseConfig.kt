package com.fardragi.dragiutils.config

import net.minecraftforge.common.config.Configuration

private const val CATEGORY = "database"

class DatabaseConfig(configuration: Configuration) {
  val host: String = configuration.getString("host", CATEGORY, "localhost", "Database host")
  val port: Int = configuration.getInt("port", CATEGORY, 3306, 0, 65535, "Database port")
  val name: String = configuration.getString("name", CATEGORY, "dragi_utils", "Database name")
  val password: String = configuration.getString("password", CATEGORY, "root", "Database password")
  val user: String = configuration.getString("user", CATEGORY, "root", "Database user")
}
