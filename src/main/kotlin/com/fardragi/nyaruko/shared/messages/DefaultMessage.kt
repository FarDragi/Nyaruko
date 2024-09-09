package com.fardragi.nyaruko.shared.messages

import net.minecraft.event.ClickEvent
import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatStyle
import net.minecraft.util.EnumChatFormatting

object DefaultMessage {
    fun usage(usage: String, command: String): ChatComponentText {
        val textComponent = ChatComponentText("Falha em executar o comando")
        textComponent.chatStyle = ChatStyle().setColor(EnumChatFormatting.RED)

        val usageComponent = ChatComponentText("[$usage]")
        usageComponent.chatStyle = ChatStyle().setColor(EnumChatFormatting.GOLD)
            .setChatClickEvent(ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help $command"))

        textComponent.appendSibling(usageComponent)

        return textComponent
    }

    fun error(message: String): ChatComponentText {
        val textComponent = ChatComponentText(message)
        textComponent.chatStyle = ChatStyle().setColor(EnumChatFormatting.RED)

        return textComponent
    }
}
