package com.fardragi.dragiutils.permission

import org.koin.dsl.module

var permissionModule = module {
    single { PermissionModule() }
    scope<PermissionModule> {

    }
}
