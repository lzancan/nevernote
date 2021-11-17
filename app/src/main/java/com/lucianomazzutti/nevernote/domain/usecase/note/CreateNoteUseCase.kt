package com.lucianomazzutti.nevernote.domain.usecase.note

interface CreateNoteUseCase {
    suspend operator fun invoke(title: String, description: String)
}