package com.fardragi.nyaruko.exceptions

import com.fardragi.nyaruko.shared.messages.MessageBuilder

class MessageException(val messageBuilder: MessageBuilder) : Exception()
