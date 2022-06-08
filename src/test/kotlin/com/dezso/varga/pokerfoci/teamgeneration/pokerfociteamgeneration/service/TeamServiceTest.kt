package com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.service

import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.domain.Player
import java.io.File
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class TeamServiceTest {

    lateinit var teamService: TeamService

    @BeforeEach
    fun setup() {
        teamService = TeamService()
    }

    @Test
    fun generateVariations() {
        val players = aPlayerList()
        val teams = teamService.generateVariations(players)
        if (teams != null) {
            assertFalse(teams.isEmpty())
        }
    }

    private fun aPlayerList(): List<Player> {
        return this::class.java.getResourceAsStream(PlayerService.PLAYERS_FILE_NAME)?.bufferedReader()?.readLines()!!.map {
            val line = it.split("\t")
            Player(line[0], line[1].toDouble())
        }.take(12)
    }
}