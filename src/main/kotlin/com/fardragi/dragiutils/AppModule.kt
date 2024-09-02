package com.fardragi.dragiutils

import com.fardragi.dragiutils.config.Config
import com.fardragi.dragiutils.config.DatabaseConfig
import com.fardragi.dragiutils.database.DatabaseConnection
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

val appModule = module {
    single { Config() } withOptions {
        createdAtStart()
    }
    single { DatabaseConfig(get()) }
    single { DatabaseConnection(get()) }
}
