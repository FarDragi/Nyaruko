package com.fardragi.nyaruko.auth

import com.fardragi.nyaruko.auth.commands.LoginCommand
import com.fardragi.nyaruko.auth.commands.RegisterCommand
import com.fardragi.nyaruko.auth.handlers.AuthHandler
import com.fardragi.nyaruko.auth.handlers.CheckHandler
import com.fardragi.nyaruko.shared.IModule
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope

class AuthModule() : KoinScopeComponent, IModule {
    override val scope by lazy { createScope(this) }

    override fun start() {
        AuthHandler(scope.get(), scope.get(), scope.get()).register()
        CheckHandler(scope.get()).register()

        RegisterCommand(scope.get()).register()
        LoginCommand(scope.get(), scope.get()).register()
    }
}
