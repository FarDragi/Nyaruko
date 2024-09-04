package com.fardragi.dragiutils.auth

import com.fardragi.dragiutils.services.UserService
import org.koin.dsl.module

val authModule = module {
    single { AuthModule() }
    scope<AuthModule> {
        scoped { UserService(get()) }
    }
}
