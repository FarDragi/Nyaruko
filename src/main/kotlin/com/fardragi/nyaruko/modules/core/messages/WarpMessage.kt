package com.fardragi.nyaruko.modules.core.messages

import com.fardragi.nyaruko.utils.TextBuilder
import net.minecraft.event.ClickEvent
import net.minecraft.event.HoverEvent
import net.minecraft.util.EnumChatFormatting

object WarpMessage {
    fun usageAction(name: String): TextBuilder {
        val command = "/$name"

        val textBuilder = TextBuilder()
            .append("$command <name>", EnumChatFormatting.YELLOW) {
                it.clickEvent(ClickEvent.Action.SUGGEST_COMMAND, command)
                it.hoverEvent(HoverEvent.Action.SHOW_TEXT) { event ->
                    event.append(command)
                }
            }

        return textBuilder
    }
}
