package com.fardragi.nyaruko.auth.commands

import com.fardragi.nyaruko.auth.messages.LoginCheckSuccessMessage
import com.fardragi.nyaruko.enums.PermissionLevel
import com.fardragi.nyaruko.services.UserService
import com.fardragi.nyaruko.shared.commands.NyarukoCommandBase
import com.fardragi.nyaruko.shared.messages.DefaultMessage
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.ChatComponentText

class LoginCommand(private val userService: UserService) : NyarukoCommandBase() {
    override fun getCommandName(): String {
        return "login"
    }

    override fun getCommandUsage(sender: ICommandSender?): String {
        return "/login <senha>"
    }

    override suspend fun processCommandPlayer(player: EntityPlayerMP, args: Array<out String>): Array<ChatComponentText> {
        if (args.isEmpty()) {
            return arrayOf(DefaultMessage.usage(getCommandUsage(player), commandName))
        }

        val userId = player.uniqueID.toString()
        val password = args[0]

        if (!userService.checkPassword(userId, password)) {
               return arrayOf(DefaultMessage.error("Senha incorreta"))
        }

        return arrayOf(LoginCheckSuccessMessage.create())
    }

    override fun getRequiredPermissionLevel(): Int {
        return PermissionLevel.True.level
    }

    override fun canCommandSenderUseCommand(sender: ICommandSender?): Boolean {
        return true
    }
}
