package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.model.Page
import com.lucianomazzutti.nevernote.domain.repository.PageRepository

class UpdatePage constructor(
    private val repository: PageRepository
): UpdatePageUseCase {
    override suspend fun invoke(page: Page) {
        repository.updatePage(page)
    }
}