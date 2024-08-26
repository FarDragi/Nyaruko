package com.fardragi.dragiutils.auth.handlers

import com.fardragi.dragiutils.database.models.UserModel
import cpw.mods.fml.common.eventhandler.EventPriority
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent
import org.jetbrains.exposed.sql.transactions.transaction

class LoginHandler {
  @SubscribeEvent(priority = EventPriority.HIGHEST)
  fun onPlayerJoin(event: PlayerLoggedInEvent) {
    val idString: String = event.player.persistentID.toString()

    transaction { UserModel.new() { setPassword("1234567899") } }

    //    val user = transaction { UserModel.findById(idString) }

    //    DragiUtils.log.info(user?.checkPassword("123456789").toString())
  }
}
