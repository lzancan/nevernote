package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.model.Note
import com.lucianomazzutti.nevernote.domain.model.Page

interface GetPagesUseCase {
    suspend operator fun invoke(): List<Page>
}