package com.fardragi.nyaruko.auth.messages

import com.fardragi.nyaruko.utils.MessageBuilder
import com.fardragi.nyaruko.utils.TextBuilder
import net.minecraft.event.ClickEvent
import net.minecraft.event.HoverEvent
import net.minecraft.util.EnumChatFormatting

object LoginMessage {
    fun usageAction(): TextBuilder {
        val textBuilder = TextBuilder()
            .append("/login <senha>", EnumChatFormatting.YELLOW) {
                it.clickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/login")
                it.hoverEvent(HoverEvent.Action.SHOW_TEXT) { event ->
                    event.append("/login")
                }
            }

        return textBuilder
    }

    fun loginBeforeGaming(): MessageBuilder {
        val messageBuilder = MessageBuilder()
            .addLine { builder ->
                builder.append("Efetue o login antes de jogar", EnumChatFormatting.RED)
            }
            .addLine(usageAction())

        return messageBuilder
    }
}
