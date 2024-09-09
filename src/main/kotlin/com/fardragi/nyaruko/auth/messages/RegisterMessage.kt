package com.fardragi.nyaruko.auth.messages

import com.fardragi.nyaruko.shared.messages.MessageBuilder
import com.fardragi.nyaruko.shared.messages.TextBuilder
import net.minecraft.event.ClickEvent
import net.minecraft.event.HoverEvent
import net.minecraft.util.EnumChatFormatting

object RegisterMessage {
    fun usageAction(): TextBuilder {
        val textBuilder = TextBuilder()
            .append("/register <senha> <repetir senha>", EnumChatFormatting.YELLOW) {
                it.clickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/register")
                it.hoverEvent(HoverEvent.Action.SHOW_TEXT) { event ->
                    event.append("/register")
                }
            }

        return textBuilder
    }

    fun alreadyRegistered(): MessageBuilder {
        val messageBuilder = MessageBuilder()
            .add { builder ->
                builder.append("Usuario ja registrado, use ", EnumChatFormatting.YELLOW)
                builder.append(LoginMessage.usageAction())
                builder.append(" para entrar", EnumChatFormatting.YELLOW)
            }

        return messageBuilder
    }

    fun success(): MessageBuilder {
        val messageBuilder = MessageBuilder()
            .add { builder ->
                builder.append("Registrado com sucesso", EnumChatFormatting.GREEN)
            }
            .add { builder ->
                builder.append("Use ", EnumChatFormatting.YELLOW)
                builder.append(LoginMessage.usageAction())
                builder.append(" para entrar", EnumChatFormatting.YELLOW)
            }

        return messageBuilder
    }
}
