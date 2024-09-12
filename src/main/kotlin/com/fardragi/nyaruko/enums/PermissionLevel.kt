package com.fardragi.nyaruko.enums

enum class PermissionLevel(val level: Int) {
    All(0),
    Op(4),
    Nobody(5);

    companion object {
        fun fromLevel(level: Int): PermissionLevel {
            return when (level) {
                0 -> All
                in 1..4 -> Op
                else -> Nobody
            }
        }
    }
}
