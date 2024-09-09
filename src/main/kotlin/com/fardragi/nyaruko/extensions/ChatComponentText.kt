package com.fardragi.nyaruko.extensions

import net.minecraft.command.ICommandSender
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ChatComponentText

fun EntityPlayer.addChatMessages(messages: Array<ChatComponentText>) {
    messages.forEach {
        this.addChatMessage(it)
    }
}

fun ICommandSender.addChatMessages(messages: Array<ChatComponentText>) {
    messages.forEach {
        this.addChatMessage(it)
    }
}
