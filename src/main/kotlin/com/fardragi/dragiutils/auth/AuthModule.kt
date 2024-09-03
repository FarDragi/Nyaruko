package com.fardragi.dragiutils.auth

import com.fardragi.dragiutils.auth.handlers.LoginHandler
import cpw.mods.fml.common.FMLCommonHandler
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope
import org.koin.core.scope.Scope

class AuthModule() : KoinScopeComponent {
    override val scope: Scope by lazy { createScope(this) }

    private lateinit var loginHandler: LoginHandler

    fun start() {
        loginHandler = LoginHandler(scope.get())
        FMLCommonHandler.instance().bus().register(loginHandler)
    }
}
