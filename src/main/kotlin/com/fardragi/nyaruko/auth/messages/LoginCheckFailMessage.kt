package com.fardragi.nyaruko.auth.messages

import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatStyle
import net.minecraft.util.EnumChatFormatting

object LoginCheckFailMessage {
    fun create(): ChatComponentText {
        val text = ChatComponentText("Password incorrect")
        text.chatStyle = ChatStyle().setColor(EnumChatFormatting.RED)

        return text
    }
}
