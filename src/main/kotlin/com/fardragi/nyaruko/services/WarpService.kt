package com.fardragi.nyaruko.services

import com.fardragi.nyaruko.database.query
import com.fardragi.nyaruko.exceptions.NotFoundException
import com.fardragi.nyaruko.models.Warp
import com.fardragi.nyaruko.viewmodels.PositionViewModel

class WarpService {
    private val warps = mutableMapOf<String, Warp>()

    suspend fun load() {
        query {
            Warp.all().forEach {
                warps[it.name] = it
            }
        }
    }

    suspend fun create(name: String, position: PositionViewModel) {
        query {
            warps[name] = Warp.new {
                this.name = name
                dimension = position.dimension
                positionX = position.block.x
                positionY = position.block.y
                positionZ = position.block.z
            }
        }
    }

    fun get(name: String): Warp {
        return warps[name] ?: throw NotFoundException(Warp::class.simpleName, name)
    }
}
