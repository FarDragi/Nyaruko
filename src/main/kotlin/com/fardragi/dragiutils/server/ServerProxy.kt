package com.fardragi.dragiutils.server

import com.fardragi.dragiutils.appModule
import com.fardragi.dragiutils.database.Database
import com.fardragi.dragiutils.database.models.User
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.event.FMLServerStartingEvent
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.ktorm.entity.add

open class ServerProxy {
    private lateinit var app: KoinApplication

    fun onPreInit(event: FMLPreInitializationEvent) {
        app = startKoin {
            modules(appModule)
        }
    }

    fun onInit(event: FMLInitializationEvent) {
        val databaseService = app.koin.get<Database>()

        val user = User {
            id = "b"
            name = "foda"
        }

        databaseService.users.add(user)
    }

    fun onPostInit(event: FMLPostInitializationEvent) {}
    fun onServerStarting(event: FMLServerStartingEvent) {}
}
