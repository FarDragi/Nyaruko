package com.fardragi.dragiutils.minecraft

import cpw.mods.fml.common.FMLCommonHandler
import java.io.File
import net.minecraft.client.Minecraft

object Utils {
    fun getWorkingDir(): File {
        val baseDir =
            if (FMLCommonHandler.instance().side.isClient) Minecraft.getMinecraft().mcDataDir
            else File(".")

        return File(baseDir, "/DragiUtils")
    }
}

