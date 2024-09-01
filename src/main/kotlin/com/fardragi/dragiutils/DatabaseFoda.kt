package com.fardragi.dragiutils

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

object UsersTable : IntIdTable("users") {
    val name = varchar("name", 50)
}

class UserModel(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserModel>(UsersTable)

    var name by UsersTable.name
}

class DatabaseFoda {
    init {
        val connectionString = "jdbc:mariadb://localhost:3306/dragi_utils"

        try {
            Database.connect(
                connectionString,
                driver = "org.mariadb.jdbc.Driver",
                user = "root",
                password = "root"
            )

            transaction {
                SchemaUtils.createMissingTablesAndColumns(UsersTable)
            }

            transaction {
                UserModel.new() {
                    name = "foda"
                }
            }
        } catch (e: Exception) {
            println("foda --------------")
            e.printStackTrace()
        }
    }
}
