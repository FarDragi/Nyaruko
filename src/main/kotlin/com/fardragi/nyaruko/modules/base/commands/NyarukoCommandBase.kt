package com.fardragi.nyaruko.modules.base.commands

import com.fardragi.nyaruko.NyarukoLog
import com.fardragi.nyaruko.enums.PermissionLevel
import com.fardragi.nyaruko.exceptions.MessageException
import com.fardragi.nyaruko.extensions.sendMessages
import com.fardragi.nyaruko.modules.base.messages.DefaultMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.command.ServerCommandManager
import net.minecraft.command.server.CommandBlockLogic
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.server.MinecraftServer
import org.koin.core.component.KoinComponent

abstract class NyarukoCommandBase : CommandBase(), KoinComponent {
    fun register() {
        (MinecraftServer.getServer().commandManager as ServerCommandManager).registerCommand(this)
    }

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
        throw MessageException(DefaultMessage.error("Você não pode usar esse comando"))
    }

    open suspend fun processCommandBlock(commandBlock: CommandBlockLogic, args: Array<out String>) {
        throw MessageException(DefaultMessage.error("O comando não pode ser usando em um comand block"))
    }

    open suspend fun processCommandConsole(sender: ICommandSender, args: Array<out String>) {
        throw MessageException(DefaultMessage.error("Você não pode usar esse comando"))
    }

    override fun getRequiredPermissionLevel(): Int {
        return getPermissionLevel().level
    }

    open fun getPermissionLevel(): PermissionLevel {
        return PermissionLevel.All
    }

    override fun canCommandSenderUseCommand(sender: ICommandSender?): Boolean {
        return true
    }
}
