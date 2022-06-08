package com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.dto

import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.domain.Player
import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.domain.TeamVariation

data class TeamVariationsDto(
    val variations: List<TeamVariation>?,
    val registeredPlayers: List<Player>
) {
}