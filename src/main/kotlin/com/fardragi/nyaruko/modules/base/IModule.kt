package com.fardragi.nyaruko.modules.base

import org.koin.core.component.KoinComponent

fun interface IModule : KoinComponent {
    suspend fun start()
}
