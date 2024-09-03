package com.fardragi.dragiutils.server

import com.fardragi.dragiutils.appModule
import com.fardragi.dragiutils.auth.AuthModule
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

open class ServerProxy {
    private lateinit var app: KoinApplication

    fun onPreInit(event: FMLPreInitializationEvent) {
        app = startKoin {
            modules(appModule)
        }
    }

    fun onInit(event: FMLInitializationEvent) {
        val authModule = app.koin.get<AuthModule>()

        authModule.start()
    }

    fun onPostInit(event: FMLPostInitializationEvent) {}
    fun onServerStarting(event: FMLServerStartingEvent) {}
}
