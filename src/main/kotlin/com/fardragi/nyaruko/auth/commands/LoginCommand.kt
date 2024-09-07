package com.fardragi.nyaruko.auth.commands

import com.fardragi.nyaruko.auth.messages.LoginCheckFailMessage
import com.fardragi.nyaruko.auth.messages.LoginCheckSuccessMessage
import com.fardragi.nyaruko.enums.PermissionLevel
import com.fardragi.nyaruko.services.UserService
import com.fardragi.nyaruko.shared.commands.NyarukoCommandBase
import com.fardragi.nyaruko.shared.messages.FailCommandMessage
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraft.util.ChatComponentText

class LoginCommand(private val userService: UserService) : NyarukoCommandBase() {
    override fun getCommandName(): String {
        return "login"
    }

    override fun getCommandUsage(sender: ICommandSender?): String {
        return "/login <password>"
    }

    override suspend fun processCommandPlayer(player: EntityPlayerMP, args: Array<out String>): ChatComponentText {
        if (args.isEmpty()) {
            return FailCommandMessage.create()
        }

        val userId = player.uniqueID.toString()
        val password = args[0]

        if (!userService.checkPassword(userId, password)) {
               return LoginCheckFailMessage.create()
        }

        return LoginCheckSuccessMessage.create()
    }

    override fun getRequiredPermissionLevel(): Int {
        return PermissionLevel.True.level
    }

    override fun canCommandSenderUseCommand(sender: ICommandSender?): Boolean {
        return true
    }
}
