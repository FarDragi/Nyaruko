package com.fardragi.nyaruko.server

import com.fardragi.nyaruko.NyarukoLog
import com.fardragi.nyaruko.appModule
import com.fardragi.nyaruko.modules.auth.AuthModule
import com.fardragi.nyaruko.modules.core.CoreModule
import com.fardragi.nyaruko.modules.permission.PermissionModule
import com.fardragi.nyaruko.modules.base.IProxy
import com.fardragi.nyaruko.modules.base.events.ServerStartingEvent
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
        runBlocking {
            CoreModule().start()
            AuthModule().start()
            PermissionModule().start()
        }
    }

    override fun onServerStarting(event: FMLServerStartingEvent) {
        NyarukoLog.info("Server starting")
        ServerStartingEvent().send()
    }
}
