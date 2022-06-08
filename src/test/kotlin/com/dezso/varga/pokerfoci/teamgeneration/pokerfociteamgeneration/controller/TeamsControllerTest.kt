package com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.controller

import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.PokerfociTeamGenerationApplication
import com.dezso.varga.pokerfoci.teamgeneration.pokerfociteamgeneration.dto.TeamVariationsDto
import org.junit.jupiter.api.Assertions
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
class TeamsControllerTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun generateTeamVariationsTest() {
        val playerListParam = listOf("csabesz","berti","dezsovarga","Dragos","Ferenc","horvathbotond","horvathkuki","kuplung","Istuu","pistike","szlo_szlo","szury")
        val result = restTemplate.postForEntity("/generate-teams",playerListParam, TeamVariationsDto::class.java)
        Assertions.assertNotNull(result)
        Assertions.assertEquals(HttpStatus.OK, result.statusCode)
    }
}