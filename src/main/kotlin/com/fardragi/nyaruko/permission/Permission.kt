package com.fardragi.nyaruko.permission

import org.koin.dsl.module

var permissionModule = module {
    single { PermissionModule() }
    scope<PermissionModule> {

    }
}
