package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.repository.PageRepository

class CreatePage constructor(
    private val repository: PageRepository
): CreatePageUseCase {
    override suspend fun invoke(title: String) {
        repository.createPage(title)
    }
}