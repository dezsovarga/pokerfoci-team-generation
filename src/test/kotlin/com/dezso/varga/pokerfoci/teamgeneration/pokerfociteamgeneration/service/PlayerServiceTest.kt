package com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class PlayerServiceTest {

    lateinit var playerService: PlayerService

    @BeforeEach
    fun setup() {
        playerService = PlayerService()
    }

    @Test
    fun `retrieve all players from resource file`() {

        val playerLines = playerService.getAllPlayers()
        assertNotNull(playerLines)
    }
}