package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.model.Note
import com.lucianomazzutti.nevernote.domain.repository.NoteRepository

class UpdateNote constructor(
    private val repository: NoteRepository
): UpdateNoteUseCase {
    override suspend fun invoke(note: Note) {
        repository.updateNote(note)
    }
}