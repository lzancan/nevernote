package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.repository.NoteRepository

class CreateNote constructor(
    private val repository: NoteRepository
): CreateNoteUseCase {
    override suspend fun invoke(title: String, description: String) {
        repository.createNote(title, description)
    }
}