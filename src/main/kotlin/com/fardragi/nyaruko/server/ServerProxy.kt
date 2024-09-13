package com.fardragi.nyaruko.server

import com.fardragi.nyaruko.NyarukoLog
import com.fardragi.nyaruko.appModule
import com.fardragi.nyaruko.auth.AuthModule
import com.fardragi.nyaruko.core.CoreModule
import com.fardragi.nyaruko.permission.PermissionModule
import com.fardragi.nyaruko.shared.IProxy
import com.fardragi.nyaruko.shared.events.ServerStartingEvent
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent
import kotlinx.coroutines.runBlocking
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class ServerProxy : IProxy {
    private lateinit var app: KoinApplication

    override fun onPreInit(event: FMLPreInitializationEvent) {
        app = startKoin {
            modules(appModule)
        }
    }

    override fun onInit(event: FMLInitializationEvent) {
        val coreModule = app.koin.get<CoreModule>()
        val authModule = app.koin.get<AuthModule>()
        val permissionModule = app.koin.get<PermissionModule>()

        runBlocking {
            coreModule.start()
            authModule.start()
            permissionModule.start()
        }
    }

    override fun onServerStarting(event: FMLServerStartingEvent) {
        NyarukoLog.info("Server starting")
        ServerStartingEvent().send()
    }
}
