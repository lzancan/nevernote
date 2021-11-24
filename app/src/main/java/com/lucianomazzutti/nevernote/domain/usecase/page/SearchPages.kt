package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.repository.PageRepository

class SearchPages constructor(
    private val repository: PageRepository
): SearchPagesUseCase {
    override suspend fun invoke(keyword: String) = repository.searchPages(keyword)


}