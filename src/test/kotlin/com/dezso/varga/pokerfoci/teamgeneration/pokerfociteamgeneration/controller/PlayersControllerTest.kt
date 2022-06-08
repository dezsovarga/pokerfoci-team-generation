package com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.controller

import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.PokerfociTeamGenerationApplication
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(
    classes = [PokerfociTeamGenerationApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class PlayersControllerTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun retrieveAllPlayersTest() {
        val result = restTemplate.getForEntity("/players", List::class.java)
        assertNotNull(result)
        assertEquals(HttpStatus.OK, result.statusCode)
        result?.body?.isEmpty()?.let { assertFalse(it) }
    }
}