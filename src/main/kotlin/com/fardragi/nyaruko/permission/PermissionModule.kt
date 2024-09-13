package com.fardragi.nyaruko.permission

import com.fardragi.nyaruko.permission.handlers.RegisterPermissionsHandler
import com.fardragi.nyaruko.shared.IModule

class PermissionModule() : IModule {
    override suspend fun start() {
        RegisterPermissionsHandler().register()
    }
}

