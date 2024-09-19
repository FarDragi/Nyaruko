package com.fardragi.nyaruko.modules.core.commands

import com.fardragi.nyaruko.exceptions.MessageException
import com.fardragi.nyaruko.extensions.teleport
import com.fardragi.nyaruko.modules.base.commands.NyarukoCommandBase
import com.fardragi.nyaruko.modules.base.messages.DefaultMessage
import com.fardragi.nyaruko.modules.core.messages.WarpMessage
import com.fardragi.nyaruko.services.WarpService
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import org.koin.core.component.inject

class WarpCommand : NyarukoCommandBase() {
    private val warpService: WarpService by inject()

    override fun getCommandName(): String {
        return "warp"
    }

    override fun getCommandUsage(sender: ICommandSender?): String {
        return "/warp <name>"
    }

    override suspend fun processCommandPlayer(player: EntityPlayerMP, args: Array<out String>) {
        if (args.isEmpty()) {
            throw MessageException(DefaultMessage.usageFail(WarpMessage.usageAction(commandName)))
        }

        val name = args[0]

        val warp = warpService.get(name)

        player.teleport(warp)
    }
}
