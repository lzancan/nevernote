package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.model.Note
import com.lucianomazzutti.nevernote.domain.model.Page

interface GetNotesUseCase {
    suspend operator fun invoke(pageId: Long): List<Note>
}