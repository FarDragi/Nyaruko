package com.fardragi.nyaruko.shared.commands

import com.fardragi.nyaruko.NyarukoLog
import com.fardragi.nyaruko.exceptions.MessageException
import com.fardragi.nyaruko.extensions.sendMessages
import com.fardragi.nyaruko.shared.messages.DefaultMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.command.server.CommandBlockLogic
import net.minecraft.entity.player.EntityPlayerMP

abstract class NyarukoCommandBase : CommandBase() {
    override fun processCommand(sender: ICommandSender, args: Array<out String>) {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                when (sender) {
                    is EntityPlayerMP -> processCommandPlayer(sender, args)
                    is CommandBlockLogic -> processCommandBlock(sender, args)
                    else -> processCommandConsole(sender, args)
                }
            } catch (e: MessageException) {
                sender.sendMessages(e.messageBuilder)
            } catch (e: Exception) {
                e.message?.let { NyarukoLog.error(it) }
                sender.sendMessages(DefaultMessage.error("Falha em executar o comando"))
            }
        }
    }

    open suspend fun processCommandPlayer(player: EntityPlayerMP, args: Array<out String>) {
        return
    }

    open suspend fun processCommandBlock(commandBlock: CommandBlockLogic, args: Array<out String>) {
        return
    }

    open suspend fun processCommandConsole(sender: ICommandSender, args: Array<out String>) {
        return
    }
}
