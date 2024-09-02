package com.fardragi.dragiutils.server

import com.fardragi.dragiutils.appModule
import com.fardragi.dragiutils.database.DatabaseConnection
import com.fardragi.dragiutils.database.models.User
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
        val databaseService = app.koin.get<DatabaseConnection>()

        val session = databaseService.session

        session.beginTransaction()
        val user = User()
        user.id = "a"
        user.name = "test";
        session.save(user)
        session.transaction.commit()
    }

    fun onPostInit(event: FMLPostInitializationEvent) {}
    fun onServerStarting(event: FMLServerStartingEvent) {}
}
