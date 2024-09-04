package com.fardragi.dragiutils.database

import org.apache.logging.log4j.LogManager
import org.jetbrains.exposed.sql.SqlLogger
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.statements.StatementContext
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

object CustomLogger : SqlLogger {
    private val logger = LogManager.getLogger("DragiUtils")

    override fun log(context: StatementContext, transaction: Transaction) {
        logger.info(context.sql(TransactionManager.current()))
    }
}

fun <T> query(block: () -> T): T {
    return transaction {
        addLogger(CustomLogger)
        block()
    }
}
