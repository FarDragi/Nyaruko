package com.fardragi.nyaruko.shared.commands

import com.fardragi.nyaruko.NyarukoLog
import com.fardragi.nyaruko.extensions.addChatMessages
import com.fardragi.nyaruko.shared.messages.DefaultMessage
import com.fardragi.nyaruko.shared.messages.NotImplementedCommandMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.command.server.CommandBlockLogic
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.ChatComponentText

abstract class NyarukoCommandBase : CommandBase() {
    override fun processCommand(sender: ICommandSender, args: Array<out String>) {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val message = when (sender) {
                    is EntityPlayerMP -> processCommandPlayer(sender, args)
                    is CommandBlockLogic -> processCommandBlock(sender, args)
                    else -> processCommandConsole(sender, args)
                }

                sender.addChatMessages(message)
            } catch (e: Exception) {
                e.message?.let { NyarukoLog.error(it) }
                sender.addChatMessage(DefaultMessage.error("Falha em executar o comando"))
            }
        }
    }

    open suspend fun processCommandPlayer(player: EntityPlayerMP, args: Array<out String>): Array<ChatComponentText> {
        return arrayOf(NotImplementedCommandMessage.create())
    }

    open suspend fun processCommandBlock(commandBlock: CommandBlockLogic, args: Array<out String>): Array<ChatComponentText> {
        return arrayOf(NotImplementedCommandMessage.create())
    }

    open suspend fun processCommandConsole(sender: ICommandSender, args: Array<out String>): Array<ChatComponentText> {
        return arrayOf(NotImplementedCommandMessage.create())
    }
}
