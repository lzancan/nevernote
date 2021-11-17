package com.lucianomazzutti.nevernote.domain.usecase.note

interface DeleteNoteUseCase {
    suspend operator fun invoke(id: Long)
}