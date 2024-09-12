package com.fardragi.nyaruko.services

import com.fardragi.nyaruko.database.query
import com.fardragi.nyaruko.database.tables.Commands
import com.fardragi.nyaruko.enums.PermissionLevel
import com.fardragi.nyaruko.models.Command

class CommandService {
    suspend fun registerCommands(commands: HashMap<String, PermissionLevel>) {
        query {
            commands.forEach {
                val command = Command.find { Commands.name eq it.key }.firstOrNull()

                if (command == null) {
                    Command.new {
                        name = it.key
                        level = it.value
                    }
                    return@forEach
                }

                command.apply {
                    level = it.value
                }
            }
        }
    }
}
