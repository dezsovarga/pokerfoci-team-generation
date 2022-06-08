package com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.controller

import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.domain.TeamVariation
import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.dto.TeamVariationsDto
import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.service.PlayerService
import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.service.TeamService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/generate-teams")
class TeamsController(
    val teamService: TeamService,
    val playerService: PlayerService
) {

    @PostMapping
    fun generateTeams(@RequestBody playerNames:List<String>): TeamVariationsDto? {
        val allPlayers = playerService.getAllPlayers()
        val registeredPlayers = playerNames.map { playerName -> allPlayers.first{ it.name.uppercase() == playerName.uppercase()} }

        return TeamVariationsDto(teamService.generateVariations(registeredPlayers), registeredPlayers)
    }
}