package com.fardragi.nyaruko.auth.messages

import com.fardragi.nyaruko.shared.messages.MessageBuilder
import net.minecraft.event.ClickEvent
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting

object WelcomeMessage {
    fun create(name: String, isRegistered: Boolean): Array<ChatComponentText> {
        val messageBuilder = MessageBuilder()
            .addDividerLine()
            .add { builder ->
                builder.append("              ")
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
                    builder.append("Logue usando /login <senha>", EnumChatFormatting.YELLOW)
                } else {
                    builder.append("Registre-se usando /register <senha> <repetir senha>", EnumChatFormatting.YELLOW)
                }
            }
            .addEmptyLine()
            .add { builder ->
                builder.append("Discord: ", EnumChatFormatting.DARK_PURPLE)
                builder.append("https://discord.gg/8KxJNzTJzq", EnumChatFormatting.BLUE) {
                    it.clickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/8KxJNzTJzq")
                }
            }
            .addDividerLine()

        return messageBuilder.build()
    }
}
