package com.quicklybly.metricgrimoire.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("spells")
data class Spell(
    @Id
    val id: Int,
    val name: String,
    val description: String,
)
