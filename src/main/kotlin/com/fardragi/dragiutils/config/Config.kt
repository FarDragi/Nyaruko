package com.fardragi.dragiutils.config

import com.fardragi.dragiutils.utils.Minecraft
import net.minecraftforge.common.config.Configuration
import java.io.File

class Config {
    val configuration = Configuration(File(Minecraft.getWorkingDir(), "config.cfg"))

    init {
        if (configuration.hasChanged())
            configuration.save()
    }
}
