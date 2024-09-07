package com.fardragi.nyaruko.shared.messages

import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatStyle
import net.minecraft.util.EnumChatFormatting

object FailCommandMessage {
    fun create(message: String = ""): ChatComponentText {
        val text = ChatComponentText("Fail to execute command: $message")
        text.chatStyle = ChatStyle().setColor(EnumChatFormatting.RED)

        return text
    }
}
