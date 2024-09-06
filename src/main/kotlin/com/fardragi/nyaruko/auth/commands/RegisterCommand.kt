package com.fardragi.nyaruko.auth.commands

import com.fardragi.nyaruko.enums.PermissionLevel
import net.minecraft.command.CommandBase
import net.minecraft.command.ICommandSender
import net.minecraft.server.MinecraftServer
import net.minecraft.util.ChatComponentText

class RegisterCommand : CommandBase() {
    override fun getCommandName(): String {
        return "register"
    }

    override fun getCommandUsage(sender: ICommandSender?): String {
        return "/register <password> <repeat password>"
    }

    override fun processCommand(sender: ICommandSender?, args: Array<out String>?) {
        val text = ChatComponentText("foda")
        MinecraftServer.getServer().configurationManager.sendChatMsg(text)
    }

    override fun getRequiredPermissionLevel(): Int {
        return PermissionLevel.True.level
    }

    override fun canCommandSenderUseCommand(sender: ICommandSender?): Boolean {
        return true
    }
}
