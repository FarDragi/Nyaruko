package com.fardragi.nyaruko.modules.permission

import com.fardragi.nyaruko.modules.permission.handlers.RegisterPermissionsHandler
import com.fardragi.nyaruko.services.GroupService
import com.fardragi.nyaruko.modules.base.IModule
import org.koin.core.component.inject

class PermissionModule() : IModule {
    private val groupService by inject<GroupService>()

    override suspend fun start() {
        groupService.checkDefault()

        RegisterPermissionsHandler().register()
    }
}

