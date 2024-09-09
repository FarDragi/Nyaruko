package com.fardragi.nyaruko.shared.messages

import net.minecraft.event.ClickEvent
import net.minecraft.event.HoverEvent
import net.minecraft.util.ChatComponentText
import net.minecraft.util.ChatStyle
import net.minecraft.util.EnumChatFormatting

class TextBuilder {
    private val componentText = ChatComponentText("").apply {
        chatStyle = ChatStyle()
    }

    fun build(): ChatComponentText {
        return componentText
    }

    fun append(
        text: String,
        color: EnumChatFormatting = EnumChatFormatting.RESET
    ): TextBuilder {
        val textBuilder = TextBuilder()
        textBuilder.text(text, color)

        componentText.appendSibling(textBuilder.build())

        return this
    }

    fun append(
        text: String,
        color: EnumChatFormatting = EnumChatFormatting.RESET,
        block: (TextBuilder) -> Unit
    ): TextBuilder {
        val textBuilder = TextBuilder()
        textBuilder.text(text, color)
        block(textBuilder)

        componentText.appendSibling(textBuilder.build())

        return this
    }

    fun append(textBuilder: TextBuilder): TextBuilder {
        componentText.appendSibling(textBuilder.build())

        return this
    }

    private fun text(text: String, color: EnumChatFormatting = EnumChatFormatting.RESET): TextBuilder {
        componentText.appendText(text)
        componentText.chatStyle.color = color

        return this
    }

    fun obfuscated(): TextBuilder {
        componentText.chatStyle.obfuscated = true

        return this
    }

    fun strikethrough(): TextBuilder {
        componentText.chatStyle.strikethrough = true

        return this
    }

    fun clickEvent(action: ClickEvent.Action, value: String): TextBuilder {
        componentText.chatStyle.chatClickEvent = ClickEvent(action, value)

        return this
    }

    fun hoverEvent(action: HoverEvent.Action, block: (TextBuilder) -> Unit): TextBuilder {
        val textBuilder = TextBuilder()
        block(textBuilder)

        componentText.chatStyle.chatHoverEvent = HoverEvent(action, textBuilder.build())

        return this
    }
}
