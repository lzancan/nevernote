package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.repository.PageRepository

class GetPages constructor(
    private val repository: PageRepository
): GetPagesUseCase {
    override suspend fun invoke() = repository.getPages()

}