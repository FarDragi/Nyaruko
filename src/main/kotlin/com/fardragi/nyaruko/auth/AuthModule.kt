package com.fardragi.nyaruko.auth

import com.fardragi.nyaruko.auth.commands.LoginCommand
import com.fardragi.nyaruko.auth.commands.RegisterCommand
import com.fardragi.nyaruko.auth.handlers.AuthHandler
import com.fardragi.nyaruko.auth.handlers.CheckHandler
import com.fardragi.nyaruko.shared.IModule

class AuthModule() : IModule {
    override suspend fun start() {
        AuthHandler().register()
        CheckHandler().register()

        RegisterCommand().register()
        LoginCommand().register()
    }
}
