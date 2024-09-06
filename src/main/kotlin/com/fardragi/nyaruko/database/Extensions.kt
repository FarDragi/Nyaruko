package com.fardragi.nyaruko.database

import com.fardragi.nyaruko.NyarukoLog
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.SqlLogger
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.statements.StatementContext
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction

object CustomLogger : SqlLogger {

    override fun log(context: StatementContext, transaction: Transaction) {
        NyarukoLog.info(context.sql(TransactionManager.current()))
    }
}

suspend fun <T> query(block: () -> T, dispatcher: CoroutineDispatcher = Dispatchers.IO): T = withContext(dispatcher) {
    transaction {
        addLogger(CustomLogger)
        block()
    }
}
