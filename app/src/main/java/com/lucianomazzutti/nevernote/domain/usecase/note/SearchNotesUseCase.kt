package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.model.Note
import com.lucianomazzutti.nevernote.domain.model.Page

interface SearchNotesUseCase {
    suspend operator fun invoke(keyword: String): List<Note>
}