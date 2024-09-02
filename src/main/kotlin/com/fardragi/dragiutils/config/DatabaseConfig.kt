package com.fardragi.dragiutils.config

private const val CATEGORY = "database"

class DatabaseConfig(config: Config) {
    val host: String = config.configuration.getString("host", CATEGORY, "localhost", "Database host")
    val port: Int = config.configuration.getInt("port", CATEGORY, 3306, 0, 65535, "Database port")
    val name: String = config.configuration.getString("name", CATEGORY, "dragi_utils", "Database name")
    val password: String = config.configuration.getString("password", CATEGORY, "root", "Database password")
    val user: String = config.configuration.getString("user", CATEGORY, "root", "Database user")

    init {
        if (config.configuration.hasChanged())
            config.configuration.save()
    }
}
