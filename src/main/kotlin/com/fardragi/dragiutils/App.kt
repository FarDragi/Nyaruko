package com.fardragi.dragiutils

import com.fardragi.dragiutils.auth.authModule
import com.fardragi.dragiutils.config.Config
import com.fardragi.dragiutils.config.DatabaseConfig
import com.fardragi.dragiutils.database.Database
import com.fardragi.dragiutils.permission.permissionModule
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

val appModule = module {
    includes(authModule, permissionModule)
    single { Config() } withOptions {
        createdAtStart()
    }
    single { DatabaseConfig(get()) }
    single { Database(get()) }
}
