package com.fardragi.dragiutils.auth

import com.fardragi.dragiutils.auth.handlers.LoginHandler
import cpw.mods.fml.common.FMLCommonHandler

class AuthModule() {

  init {
    FMLCommonHandler.instance().bus().register(LoginHandler())
  }
}
