package com.fardragi.nyaruko.shared.messages

import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting

class MessageBuilder {
    private val messages = mutableListOf<ChatComponentText>()

    fun build(): Array<ChatComponentText> {
        return messages.toTypedArray()
    }

    fun add(block: (TextBuilder) -> Unit): MessageBuilder {
        val textBuilder = TextBuilder()
        block(textBuilder)
        messages.add(textBuilder.build())

        return this
    }

    fun add(textBuilder: TextBuilder): MessageBuilder {
        messages.add(textBuilder.build())

        return this
    }

    fun addEmptyLine(): MessageBuilder {
        add { builder ->
            builder.append("")
        }

        return this
    }

    fun addDividerLine(): MessageBuilder {
        add { builder ->
            builder.append("-----------------------------------------------------", EnumChatFormatting.GOLD)
                .strikethrough()
        }

        return this
    }
}
