package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.model.Page

interface SearchPagesUseCase {
    suspend operator fun invoke(keyword: String): List<Page>
}