package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.repository.NoteRepository

class GetNotes constructor(
    private val repository: NoteRepository
): GetNotesUseCase {
    override suspend fun invoke(pageId: Long) = repository.getNotes(pageId)
}