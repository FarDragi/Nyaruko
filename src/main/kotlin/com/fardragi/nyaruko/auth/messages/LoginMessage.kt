package com.fardragi.nyaruko.auth.messages

import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatStyle
import net.minecraft.util.EnumChatFormatting

object LoginMessage {
    fun create(): ChatComponentText {
        val text = ChatComponentText("use /login <password>");
        text.chatStyle = ChatStyle().setColor(EnumChatFormatting.YELLOW)

        return text
    }
}
