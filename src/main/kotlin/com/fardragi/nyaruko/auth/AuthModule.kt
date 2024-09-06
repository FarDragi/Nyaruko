package com.fardragi.nyaruko.auth

import com.fardragi.nyaruko.auth.commands.RegisterCommand
import com.fardragi.nyaruko.auth.handlers.LoginHandler
import cpw.mods.fml.common.FMLCommonHandler
import net.minecraft.command.ServerCommandManager
import net.minecraft.server.MinecraftServer
import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope

class AuthModule() : KoinScopeComponent {
    override val scope by lazy { createScope(this) }

    private lateinit var loginHandler: LoginHandler
    private var commandManager = MinecraftServer.getServer().commandManager as ServerCommandManager

    fun start() {
        loginHandler = LoginHandler(scope.get())
        FMLCommonHandler.instance().bus().register(loginHandler)

        commandManager.registerCommand(RegisterCommand())
    }
}
