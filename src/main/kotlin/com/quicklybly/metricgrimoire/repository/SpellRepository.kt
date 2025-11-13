package com.quicklybly.metricgrimoire.repository

import com.quicklybly.metricgrimoire.model.Spell
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface SpellRepository : CrudRepository<Spell, Int> {

    @Query(
        """
        SELECT * 
        FROM spells
        WHERE id > :lastId
        ORDER BY id
        LIMIT :limit
        """
    )
    fun getSpells(
        @Param("lastId") lastId: Int,
        @Param("limit") limit: Int,
    ): List<Spell>
}
