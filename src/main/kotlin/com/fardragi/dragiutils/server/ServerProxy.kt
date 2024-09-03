package com.fardragi.dragiutils.server

import com.fardragi.dragiutils.appModule
import com.fardragi.dragiutils.auth.AuthModule
import com.fardragi.dragiutils.database.Database
import com.fardragi.dragiutils.models.User
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent
import io.netty.util.internal.logging.InternalLoggerFactory
import io.netty.util.internal.logging.Log4JLoggerFactory
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.ktorm.entity.add
import org.slf4j.LoggerFactory

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
