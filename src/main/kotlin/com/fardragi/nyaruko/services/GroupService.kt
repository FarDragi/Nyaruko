package com.fardragi.nyaruko.services

import com.fardragi.nyaruko.database.query
import com.fardragi.nyaruko.database.tables.Groups
import com.fardragi.nyaruko.exceptions.NotFoundException
import com.fardragi.nyaruko.models.Group
import com.fardragi.nyaruko.models.User
import com.fardragi.nyaruko.models.UserGroup

class GroupService {
    suspend fun checkDefault() {
        query {
            val group = Group.find { Groups.default eq true }.firstOrNull()

            if (group == null) {
                Group.new {
                    name = "default"
                    order = Group.all().maxByOrNull { Groups.order }?.order?.plus(1u) ?: 0u
                    default = true
                }
            }
        }
    }

    suspend fun registerUserInDefaultGroup(user: User) {
        query {
            val group = Group.find { Groups.default eq true }.firstOrNull() ?: throw NotFoundException(
                Group::class.simpleName,
                "default"
            )

            UserGroup.new {
                userId = user.id
                groupId = group.id
            }
        }
    }
}
