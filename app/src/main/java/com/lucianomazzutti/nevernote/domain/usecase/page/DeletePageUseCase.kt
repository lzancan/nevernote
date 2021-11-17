package com.lucianomazzutti.nevernote.domain.usecase.page

interface DeletePageUseCase {
    suspend operator fun invoke(id: Long)
}