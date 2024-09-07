package com.fardragi.nyaruko.auth.messages

import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatStyle
import net.minecraft.util.EnumChatFormatting

object LoginCheckSuccessMessage {
    fun create(): ChatComponentText {
        val text = ChatComponentText("Login with success")
        text.chatStyle = ChatStyle().setColor(EnumChatFormatting.GREEN)

        return text
    }
}
