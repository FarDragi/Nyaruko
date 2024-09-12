package com.fardragi.nyaruko.auth.commands

import com.fardragi.nyaruko.auth.messages.LoginMessage
import com.fardragi.nyaruko.enums.PermissionLevel
import com.fardragi.nyaruko.exceptions.MessageException
import com.fardragi.nyaruko.extensions.sendMessages
import com.fardragi.nyaruko.services.SessionsService
import com.fardragi.nyaruko.services.UserService
import com.fardragi.nyaruko.shared.commands.NyarukoCommandBase
import com.fardragi.nyaruko.shared.messages.DefaultMessage
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginCommand() : NyarukoCommandBase(), KoinComponent {
    private val userService: UserService by inject()
    private val sessionsService: SessionsService by inject()

    override fun getCommandName(): String {
        return "login"
    }

    override fun getCommandUsage(sender: ICommandSender?): String {
        return "/login <senha>"
    }

    override suspend fun processCommandPlayer(player: EntityPlayerMP, args: Array<out String>) {
        if (args.isEmpty()) {
            throw MessageException(DefaultMessage.usage(LoginMessage.usageAction()))
        }

        val userId = player.uniqueID
        val password = args[0]

        if (sessionsService.isAuthenticated(userId)){
            throw MessageException(DefaultMessage.error("Você ja esta logado"))
        }

        if (!userService.checkPassword(userId, password)) {
            throw MessageException(DefaultMessage.error("Senha incorreta"))
        }

        player.sendMessages(DefaultMessage.success("Logado com sucesso"))
        sessionsService.setAuthenticate(userId)
    }

    override fun getRequiredPermissionLevel(): Int {
        return PermissionLevel.All.level
    }

    override fun canCommandSenderUseCommand(sender: ICommandSender?): Boolean {
        return true
    }
}
