package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.model.Page

interface UpdatePageUseCase {
    suspend operator fun invoke(page: Page)
}