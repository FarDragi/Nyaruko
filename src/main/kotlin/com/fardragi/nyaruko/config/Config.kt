package com.fardragi.nyaruko.config

import com.fardragi.nyaruko.utils.Minecraft
import net.minecraftforge.common.config.Configuration
import java.io.File

class Config {
    val configuration = Configuration(File(Minecraft.getWorkingDir(), "config.cfg"))

    init {
        save()
    }

    fun save() {
        if (configuration.hasChanged())
            configuration.save()
    }
}
