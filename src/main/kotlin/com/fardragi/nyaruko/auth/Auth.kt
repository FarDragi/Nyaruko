package com.fardragi.nyaruko.auth

import com.fardragi.nyaruko.services.UserService
import org.koin.dsl.module

val authModule = module {
    single { AuthModule() }
    scope<AuthModule> {
        scoped { UserService() }
    }
}
