package com.fardragi.nyaruko.auth.messages

import net.minecraft.event.ClickEvent
import net.minecraft.event.HoverEvent
import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatStyle
import net.minecraft.util.EnumChatFormatting

object LoginMessage {
    fun create(): ChatComponentText {
        val command = ChatComponentText("/login <password>")
        command.chatStyle = ChatStyle()
            .setChatClickEvent(ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/login"))
            .setChatHoverEvent(HoverEvent(HoverEvent.Action.SHOW_TEXT, ChatComponentText("/login")))

        val text = ChatComponentText("use ")
        text.chatStyle = ChatStyle().setColor(EnumChatFormatting.YELLOW)
        text.appendSibling(command)

        return text
    }
}
