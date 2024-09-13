package com.fardragi.nyaruko.permission.handlers

import com.fardragi.nyaruko.enums.PermissionLevel
import com.fardragi.nyaruko.services.CommandService
import com.fardragi.nyaruko.services.GroupService
import com.fardragi.nyaruko.shared.events.ServerStartingEvent
import com.fardragi.nyaruko.shared.handlers.NyarukoHandlerBase
import cpw.mods.fml.common.eventhandler.EventPriority
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.minecraft.command.CommandBase
import net.minecraft.server.MinecraftServer
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RegisterPermissionsHandler : NyarukoHandlerBase(), KoinComponent {
    private val commandService: CommandService by inject()
    private val groupService: GroupService by inject()

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun onServerStart(event: ServerStartingEvent) {
        val commands = MinecraftServer.getServer().commandManager.commands.mapValues { (_, v) ->
            return@mapValues if (v is CommandBase)
                PermissionLevel.fromLevel(v.requiredPermissionLevel)
            else PermissionLevel.Op
        }

        CoroutineScope(Dispatchers.Default).launch {
            groupService.checkDefault()
            commandService.registerCommands(commands as HashMap<String, PermissionLevel>)
        }
    }
}
