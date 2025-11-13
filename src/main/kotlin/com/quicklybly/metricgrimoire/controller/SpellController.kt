package com.quicklybly.metricgrimoire.controller

import com.quicklybly.metricgrimoire.service.SpellService
import jakarta.websocket.server.PathParam
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    path = ["v1/spells"],
    consumes = [MediaType.APPLICATION_JSON_VALUE],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class SpellController(private val service: SpellService) {

    @GetMapping
    fun getSpells(
        @PathParam("pageToken") pageToken: String?,
        @PathParam("maxResults") maxResults: Int?,
    ) = service.getSpells(pageToken, maxResults)
}
