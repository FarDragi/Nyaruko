package com.fardragi.nyaruko

import org.apache.logging.log4j.LogManager

object NyarukoLog {
    private val logger = LogManager.getLogger("Nyaruko")

    fun info(message: String) {
        logger.info(message)
    }
}
