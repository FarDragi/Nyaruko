package com.fardragi.nyaruko.permission

import org.koin.dsl.module

val permissionModule = module {
    single { PermissionModule() }
    scope<PermissionModule> {

    }
}
