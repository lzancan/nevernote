package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.model.Note

interface UpdateNoteUseCase {
    suspend operator fun invoke(note: Note)
}