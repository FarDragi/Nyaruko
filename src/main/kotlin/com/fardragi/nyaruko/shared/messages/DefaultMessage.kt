package com.fardragi.nyaruko.shared.messages

import net.minecraft.util.EnumChatFormatting

object DefaultMessage {
    fun usage(usageAction: TextBuilder): MessageBuilder {
        val messageBuilder = MessageBuilder()
            .add { builder ->
                builder.append("Falha ao executar", EnumChatFormatting.RED)
            }
            .add { builder ->
                builder.append("Use ", EnumChatFormatting.YELLOW)
                builder.append(usageAction)
            }

        return messageBuilder
    }

    fun error(message: String): MessageBuilder {
        val messageBuilder = MessageBuilder()
            .add { builder ->
                builder.append(message, EnumChatFormatting.RED)
            }

        return messageBuilder
    }

    fun success(message: String): MessageBuilder {
        val messageBuilder = MessageBuilder()
            .add { builder ->
                builder.append(message, EnumChatFormatting.GREEN)
            }

        return messageBuilder
    }
}
