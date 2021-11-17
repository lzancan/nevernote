package com.lucianomazzutti.nevernote.domain.usecase.page

interface CreatePageUseCase {
    suspend operator fun invoke(title: String)
}