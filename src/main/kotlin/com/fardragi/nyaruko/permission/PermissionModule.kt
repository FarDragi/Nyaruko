package com.fardragi.nyaruko.permission

import com.fardragi.nyaruko.enums.PermissionLevel
import com.fardragi.nyaruko.services.CommandService
import com.fardragi.nyaruko.shared.IModule
import net.minecraft.command.CommandBase
import net.minecraft.server.MinecraftServer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PermissionModule() : IModule, KoinComponent {
    private val commandService: CommandService by inject()

    override suspend fun start() {
        val commands = MinecraftServer.getServer().commandManager.commands.mapValues { (_, v) ->
            return@mapValues if (v is CommandBase)
                PermissionLevel.fromLevel(v.requiredPermissionLevel)
            else PermissionLevel.Op
        }

        commandService.registerCommands(commands as HashMap<String, PermissionLevel>)
    }
}
