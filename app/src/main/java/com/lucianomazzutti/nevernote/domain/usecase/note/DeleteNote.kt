package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.repository.NoteRepository

class DeleteNote constructor(
    private val repository: NoteRepository
): DeleteNoteUseCase {
    override suspend fun invoke(id: Long) {
        repository.deleteNote(id)
    }
}