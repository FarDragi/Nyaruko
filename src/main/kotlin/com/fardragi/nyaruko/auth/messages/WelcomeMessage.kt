package com.fardragi.nyaruko.auth.messages

import com.fardragi.nyaruko.shared.messages.MessageBuilder
import net.minecraft.event.ClickEvent
import net.minecraft.util.EnumChatFormatting

object WelcomeMessage {
    fun create(isRegistered: Boolean, discordInvite: String): MessageBuilder {
        val messageBuilder = MessageBuilder()
            .addDividerLine()
            .add { builder ->
                builder.append("               ")
                builder.append("123", EnumChatFormatting.AQUA) {
                    it.obfuscated()
                }
                builder.append(" Seja bem vindo ao servidor ")
                builder.append("123", EnumChatFormatting.AQUA) {
                    it.obfuscated()
                }
            }
            .addEmptyLine()
            .add { builder ->
                if (isRegistered) {
                    builder.append("Logue usando ", EnumChatFormatting.YELLOW)
                    builder.append(LoginMessage.usageAction())
                } else {
                    builder.append("Registre-se usando ", EnumChatFormatting.YELLOW)
                    builder.append(RegisterMessage.usageAction())
                }
            }
            .addEmptyLine()
            .add { builder ->
                builder.append("Discord: ", EnumChatFormatting.DARK_PURPLE)
                builder.append(discordInvite, EnumChatFormatting.BLUE) {
                    it.clickEvent(ClickEvent.Action.OPEN_URL, discordInvite)
                }
            }
            .addDividerLine()

        return messageBuilder
    }
}
