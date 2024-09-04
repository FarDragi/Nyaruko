package com.fardragi.dragiutils.database

import org.apache.logging.log4j.LogManager
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.statements.StatementContext
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

class ExposedDatabase {
    init {
        val database = Database.connect(
            "jdbc:mariadb://localhost:3306/dragi_utils",
            driver = "org.mariadb.jdbc.Driver",
            user = "root",
            password = "root"
        )

        transaction {
            addLogger(CustomLogger)

            SchemaUtils.create(Tests)
        }

        transaction {
            addLogger(CustomLogger)

            val user = Test.new {
                name = "test"
            }
        }
    }
}

object Tests : IntIdTable("test") {
    var name = varchar("name", 255)
}

class Test(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Test>(Tests)

    var name by Tests.name
}

object CustomLogger : SqlLogger {
    private val logger = LogManager.getLogger("DragiUtils")

    override fun log(context: StatementContext, transaction: Transaction) {
        logger.info(context.sql(TransactionManager.current()))
    }
}
