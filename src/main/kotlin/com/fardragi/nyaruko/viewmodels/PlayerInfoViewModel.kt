package com.fardragi.nyaruko.viewmodels

data class PlayerInfoViewModel(val name: String, val initialPosition: PositionViewModel) {
    var authenticated: Boolean = false
}
