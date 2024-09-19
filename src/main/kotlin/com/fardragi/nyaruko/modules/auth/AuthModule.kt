package com.fardragi.nyaruko.modules.auth

import com.fardragi.nyaruko.modules.auth.commands.LoginCommand
import com.fardragi.nyaruko.modules.auth.commands.RegisterCommand
import com.fardragi.nyaruko.modules.auth.handlers.AuthHandler
import com.fardragi.nyaruko.modules.auth.handlers.CheckHandler
import com.fardragi.nyaruko.modules.base.IModule

class AuthModule() : IModule {
    override suspend fun start() {
        AuthHandler().register()
        CheckHandler().register()

        RegisterCommand().register()
        LoginCommand().register()
    }
}
