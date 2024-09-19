package com.fardragi.nyaruko.modules.core.commands

import com.fardragi.nyaruko.enums.PermissionLevel
import com.fardragi.nyaruko.exceptions.MessageException
import com.fardragi.nyaruko.extensions.sendMessages
import com.fardragi.nyaruko.modules.base.commands.NyarukoCommandBase
import com.fardragi.nyaruko.modules.base.messages.DefaultMessage
import com.fardragi.nyaruko.modules.core.messages.WarpMessage
import com.fardragi.nyaruko.services.WarpService
import com.fardragi.nyaruko.viewmodels.PositionViewModel
import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayerMP
import org.koin.core.component.inject

class SetWarpCommand : NyarukoCommandBase() {
    private val warpService: WarpService by inject()

    override fun getCommandName(): String {
        return "setwarp"
    }

    override fun getCommandUsage(sender: ICommandSender?): String {
        return "/setwarp <name>"
    }

    override fun getPermissionLevel(): PermissionLevel {
        return PermissionLevel.Op
    }

    override suspend fun processCommandPlayer(player: EntityPlayerMP, args: Array<out String>) {
        if (args.isEmpty()) {
            throw MessageException(DefaultMessage.usageFail(WarpMessage.usageAction(commandName)))
        }

        val location = PositionViewModel(player)
        val name = args[0]

        warpService.create(name, location)

        player.sendMessages(DefaultMessage.success("Warp criada com sucesso"))
    }
}
