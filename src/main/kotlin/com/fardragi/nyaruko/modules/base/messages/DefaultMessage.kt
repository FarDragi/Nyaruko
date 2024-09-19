package com.fardragi.nyaruko.modules.base.messages

import com.fardragi.nyaruko.utils.MessageBuilder
import com.fardragi.nyaruko.utils.TextBuilder
import net.minecraft.util.EnumChatFormatting

object DefaultMessage {
    fun usageFail(usageAction: TextBuilder): MessageBuilder {
        val messageBuilder = MessageBuilder()
            .addLine { builder ->
                builder.append("Falha ao executar", EnumChatFormatting.RED)
            }
            .addLine { builder ->
                builder.append("Use ", EnumChatFormatting.YELLOW)
                builder.append(usageAction)
            }

        return messageBuilder
    }

    fun error(message: String): MessageBuilder {
        val messageBuilder = MessageBuilder()
            .addLine { builder ->
                builder.append(message, EnumChatFormatting.RED)
            }

        return messageBuilder
    }

    fun success(message: String): MessageBuilder {
        val messageBuilder = MessageBuilder()
            .addLine { builder ->
                builder.append(message, EnumChatFormatting.GREEN)
            }

        return messageBuilder
    }
}
