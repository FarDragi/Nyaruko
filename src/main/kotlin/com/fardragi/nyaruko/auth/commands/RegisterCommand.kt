package com.fardragi.nyaruko.auth.commands

import com.fardragi.nyaruko.auth.messages.RegisterMessage
import com.fardragi.nyaruko.enums.PermissionLevel
import com.fardragi.nyaruko.exceptions.MessageException
import com.fardragi.nyaruko.extensions.sendMessages
import com.fardragi.nyaruko.services.UserService
import com.fardragi.nyaruko.shared.commands.NyarukoCommandBase
import com.fardragi.nyaruko.shared.messages.DefaultMessage
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RegisterCommand() : NyarukoCommandBase(), KoinComponent {
    private val userService: UserService by inject()

    override fun getCommandName(): String {
        return "register"
    }

    override fun getCommandUsage(sender: ICommandSender?): String {
        return "/register <senha> <repetir senha>"
    }

    override suspend fun processCommandPlayer(player: EntityPlayerMP, args: Array<out String>) {
        if (args.isEmpty() || args.size < 2) {
            throw MessageException(DefaultMessage.usage(RegisterMessage.usageAction()))
        }

        val userId = player.uniqueID
        val password = args[0]
        val repeatPassword = args[1]

        val user = userService.getById(userId)

        if (user.isRegistered) {
            throw MessageException(RegisterMessage.alreadyRegistered())
        }

        if (password != repeatPassword) {
            throw MessageException(DefaultMessage.error("As senhas não são iguais"))
        }

        userService.setPassword(userId, repeatPassword)

        player.sendMessages(RegisterMessage.success())
    }

    override fun getRequiredPermissionLevel(): Int {
        return PermissionLevel.All.level
    }

    override fun canCommandSenderUseCommand(sender: ICommandSender?): Boolean {
        return true
    }
}
