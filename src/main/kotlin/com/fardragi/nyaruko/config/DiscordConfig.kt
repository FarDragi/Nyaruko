package com.fardragi.nyaruko.config

private const val CATEGORY = "discord"

class DiscordConfig(config: Config) {
    val discordInvite: String = config.configuration.getString("discordInvite", CATEGORY, "https://discord.gg/", "Link for discord invite")

    init {
        config.save()
    }
}
