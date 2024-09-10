package com.fardragi.nyaruko.extensions

import com.fardragi.nyaruko.utils.MessageBuilder
import net.minecraft.command.ICommandSender

fun ICommandSender.sendMessages(messageBuilder: MessageBuilder) {
    messageBuilder.build().forEach {
        this.addChatMessage(it)
    }
}
