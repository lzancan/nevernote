package com.lucianomazzutti.nevernote.domain.repository

import com.lucianomazzutti.nevernote.domain.model.Page

interface PageRepository {
    suspend fun createPage(title: String)
    suspend fun updatePage(page: Page)
    suspend fun deletePage(id: Long)
    suspend fun getPages(): List<Page>
    suspend fun searchPages(keyword: String): List<Page>
}