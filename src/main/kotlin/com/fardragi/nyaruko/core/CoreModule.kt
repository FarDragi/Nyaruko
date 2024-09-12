package com.fardragi.nyaruko.core

import com.fardragi.nyaruko.core.handlers.PlayerTickHandler
import com.fardragi.nyaruko.shared.IModule
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope

class CoreModule() : KoinScopeComponent, IModule {
    override val scope by lazy { createScope(this) }

    override suspend fun start() {
        PlayerTickHandler().register()
    }
}
