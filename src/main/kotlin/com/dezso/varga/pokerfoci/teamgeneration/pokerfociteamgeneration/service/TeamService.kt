package com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.service

import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.domain.Player
import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.domain.Team
import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.domain.TeamVariation
import kotlin.math.abs
import org.paukov.combinatorics3.Generator
import org.springframework.stereotype.Service

@Service
class TeamService {

    fun generateVariations(players: List<Player>): List<TeamVariation>? {
        val teamVariations = Generator.combination(players)
            .simple(players.size/2)
            .map {
                it.sortByDescending { player -> player.skill }
                val team1 = Team(it)
                val team2 = getOtherTeam(team1, players)
                TeamVariation(team1, team2, getTeamDifference(team1, team2))
            }.filter { variation -> variation.difference < 2 }.sortedBy { it.difference }
        return teamVariations.take(20).filterIndexed { index, _ -> index % 2 == 0  }
    }

    private fun getOtherTeam(team1: Team, allPlayers: List<Player>): Team {
        val team2Players = allPlayers.filter { player -> !team1.players.contains(player) }.sortedByDescending { it.skill }
        return Team(team2Players)
    }

    private fun getTeamDifference(team1: Team, team2: Team) : Double =
        abs(team1.players.sumOf { it.skill } - team2.players.sumOf { it.skill })
}