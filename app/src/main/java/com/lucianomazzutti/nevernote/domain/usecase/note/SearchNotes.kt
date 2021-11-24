package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.repository.NoteRepository

class SearchNotes constructor(
    private val repository: NoteRepository
): SearchNotesUseCase {
    override suspend fun invoke(keyword: String) = repository.searchNotes(keyword)
}