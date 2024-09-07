package com.fardragi.nyaruko.auth.messages

import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatStyle
import net.minecraft.util.EnumChatFormatting

object AlreadyRegisteredMessage {
    fun create(): ChatComponentText {
        val text = ChatComponentText("User already registered")
        text.chatStyle = ChatStyle().setColor(EnumChatFormatting.YELLOW)

        return text
    }
}
