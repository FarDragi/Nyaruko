package com.fardragi.dragiutils.database

import com.fardragi.dragiutils.config.DatabaseConfig
import com.fardragi.dragiutils.database.models.User
import org.hibernate.cfg.Configuration

class DatabaseConnection(private val config: DatabaseConfig) {
    private val sessionFactory = Configuration()
        .setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect")
        .setProperty("hibernate.connection.driver_class", "org.mariadb.jdbc.Driver")
        .setProperty("hibernate.connection.url", "jdbc:mariadb://${config.host}:${config.port}/${config.name}")
        .setProperty("hibernate.connection.username", config.user)
        .setProperty("hibernate.connection.password", config.password)
        .setProperty("hibernate.hbm2ddl.auto", "update")
        .setProperty("hibernate.show_sql", "true")
        .addAnnotatedClass(User::class.java)
        .buildSessionFactory()

    val session
        get() = sessionFactory.openSession();
}
