package com.fardragi.dragiutils.config

import com.fardragi.dragiutils.utils.getWorkingDir
import net.minecraftforge.common.config.Configuration
import java.io.File

class Config {
    val configuration = Configuration(File(getWorkingDir(), "config.cfg"))

    init {
        if (configuration.hasChanged())
            configuration.save()
    }
}
