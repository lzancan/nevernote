package com.lucianomazzutti.nevernote.domain.model

data class Page(
    val id: Long,
    val title: String,
    val notes: List<Note>
)
