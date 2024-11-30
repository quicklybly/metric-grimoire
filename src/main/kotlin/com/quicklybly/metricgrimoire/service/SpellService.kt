package com.quicklybly.metricgrimoire.service

import com.quicklybly.metricgrimoire.model.Spell
import com.quicklybly.metricgrimoire.repository.SpellRepository
import org.springframework.stereotype.Service
import java.util.Base64

@Service
class SpellService(private val repository: SpellRepository) {

    fun getSpells(
        @Suppress("UnusedParameter") pageTokenString: String?,
        maxResults: Int?,
    ): List<Spell> {
        return repository.getSpells(0, maxResults ?: MAX_RESULTS_DEFAULT_VALUE)
    }

    @Suppress("UnusedPrivateProperty")
    companion object {
        private const val MAX_SIZE_LIMIT = 100
        private const val MAX_RESULTS_DEFAULT_VALUE = 20
        private const val MAX_RESULTS_MAX_VALUE = 100
        private const val EMPTY_NEXT_PAGE_TOKEN = ""

        private val base64Encoder = Base64.getUrlEncoder()
        private val base64Decoder = Base64.getUrlDecoder()
    }
}
