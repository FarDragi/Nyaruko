package com.fardragi.nyaruko

import com.fardragi.nyaruko.auth.authModule
import com.fardragi.nyaruko.config.Config
import com.fardragi.nyaruko.config.DatabaseConfig
import com.fardragi.nyaruko.config.DiscordConfig
import com.fardragi.nyaruko.database.DatabaseConnection
import com.fardragi.nyaruko.permission.permissionModule
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

val appModule = module {
    includes(authModule, permissionModule)
    single { Config() } withOptions {
        createdAtStart()
    }
    single { DatabaseConfig(get()) }
    single { DiscordConfig(get()) }
    single { DatabaseConnection(get()) } withOptions {
        createdAtStart()
    }
}
