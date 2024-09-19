package com.fardragi.nyaruko

import com.fardragi.nyaruko.modules.auth.AuthModule
import com.fardragi.nyaruko.config.Config
import com.fardragi.nyaruko.config.DatabaseConfig
import com.fardragi.nyaruko.config.DiscordConfig
import com.fardragi.nyaruko.modules.core.CoreModule
import com.fardragi.nyaruko.database.DatabaseConnection
import com.fardragi.nyaruko.modules.permission.PermissionModule
import com.fardragi.nyaruko.services.*
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.dsl.module

val appModule = module {
    single { Config() } withOptions {
        createdAtStart()
    }
    single { DatabaseConfig(get()) }
    single { DiscordConfig(get()) }

    single { DatabaseConnection(get()) } withOptions {
        createdAtStart()
    }

    single { UserService(get()) }
    single { SessionsService() }
    single { CommandService() }
    single { GroupService() }
    single { WarpService() }
}
