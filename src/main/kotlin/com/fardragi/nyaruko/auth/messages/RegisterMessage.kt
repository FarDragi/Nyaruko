package com.fardragi.nyaruko.auth.messages

import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatStyle
import net.minecraft.util.EnumChatFormatting

object RegisterMessage {
    fun create(): ChatComponentText {
        val text = ChatComponentText("use /register <password> <password>");
        text.chatStyle = ChatStyle().setColor(EnumChatFormatting.YELLOW)

        return text
    }
}
