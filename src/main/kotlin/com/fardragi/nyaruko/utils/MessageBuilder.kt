package com.fardragi.nyaruko.utils

import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting

class MessageBuilder {
    private val messages = mutableListOf<ChatComponentText>()

    fun build(): Array<ChatComponentText> {
        return messages.toTypedArray()
    }

    fun addLine(block: (TextBuilder) -> Unit): MessageBuilder {
        val textBuilder = TextBuilder()
        block(textBuilder)
        messages.add(textBuilder.build())

        return this
    }

    fun addLine(textBuilder: TextBuilder): MessageBuilder {
        messages.add(textBuilder.build())

        return this
    }

    fun addEmptyLine(): MessageBuilder {
        addLine { builder ->
            builder.append("")
        }

        return this
    }

    fun addDividerLine(): MessageBuilder {
        addLine { builder ->
            builder.append("-----------------------------------------------------", EnumChatFormatting.GOLD)
                .strikethrough()
        }

        return this
    }
}
