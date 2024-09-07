package com.fardragi.nyaruko.shared.messages

import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatStyle
import net.minecraft.util.EnumChatFormatting

object NotImplementedCommandMessage {
    fun create(): ChatComponentText {
        val text = ChatComponentText("Command not implemented")
        text.chatStyle = ChatStyle().setColor(EnumChatFormatting.RED)

        return text
    }

}
