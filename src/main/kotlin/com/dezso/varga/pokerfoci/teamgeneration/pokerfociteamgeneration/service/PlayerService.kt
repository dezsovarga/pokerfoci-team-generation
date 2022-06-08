package com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.service

import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.domain.Player
import java.io.File
import org.paukov.combinatorics3.Generator
import org.springframework.stereotype.Service

@Service
class PlayerService {

    companion object {
        const val PLAYERS_FILE_NAME = "/players.txt"
    }

    fun getAllPlayers(): List<Player> {
        return this::class.java.getResourceAsStream(PLAYERS_FILE_NAME)?.bufferedReader()?.readLines()!!.map {
            val line = it.split("\t")
            Player(line[0].trim(), line[1].toDouble())
        }
    }
}