package com.fardragi.nyaruko.database

import com.fardragi.nyaruko.NyarukoLog
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.SqlLogger
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.statements.StatementContext
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.experimental.withSuspendTransaction

object CustomLogger : SqlLogger {
    override fun log(context: StatementContext, transaction: Transaction) {
        NyarukoLog.info(context.sql(TransactionManager.current()))
    }
}

suspend fun <T> query(dispatcher: CoroutineDispatcher = Dispatchers.IO, block: suspend () -> T): T {
    return newSuspendedTransaction(dispatcher) {
        withSuspendTransaction {
            addLogger(CustomLogger)
            block()
        }
    }
}
