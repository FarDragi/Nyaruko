package com.fardragi.nyaruko.modules.core

import com.fardragi.nyaruko.modules.core.handlers.PlayerTickHandler
import com.fardragi.nyaruko.modules.base.IModule
import com.fardragi.nyaruko.modules.core.commands.SetWarpCommand
import com.fardragi.nyaruko.modules.core.commands.WarpCommand
import com.fardragi.nyaruko.services.WarpService
import org.koin.core.component.inject

class CoreModule() : IModule {
    private val warpService: WarpService by inject()

    override suspend fun start() {
        warpService.load()

        PlayerTickHandler().register()

        WarpCommand().register()
        SetWarpCommand().register()
    }
}
