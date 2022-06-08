package com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.controller

import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.domain.Player
import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.service.PlayerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/players")
class PlayersController(
    val playerService: PlayerService
) {

    @GetMapping
    fun retrieveAllPlayers(): List<Player> {
        return playerService.getAllPlayers()
    }
}