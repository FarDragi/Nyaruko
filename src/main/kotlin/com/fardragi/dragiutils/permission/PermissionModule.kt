package com.fardragi.dragiutils.permission

import org.koin.core.component.KoinScopeComponent
import org.koin.core.component.createScope

class PermissionModule() : KoinScopeComponent {
    override val scope by lazy { createScope(this) }
}
