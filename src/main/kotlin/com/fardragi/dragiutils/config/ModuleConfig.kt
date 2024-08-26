package com.fardragi.dragiutils.config

import net.minecraftforge.common.config.Configuration

private const val CATEGORY = "module"

class ModuleConfig(configuration: Configuration) {
  val auth: Boolean = configuration.getBoolean("auth", CATEGORY, false, "Enable auth system")
}
