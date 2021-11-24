package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.repository.PageRepository

class DeletePage constructor(
    private val repository: PageRepository
): DeletePageUseCase {
    override suspend fun invoke(id: Long) {
        repository.deletePage(id)
    }
}