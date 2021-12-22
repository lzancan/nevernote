package com.lucianomazzutti.nevernote.data.datasource

import com.lucianomazzutti.nevernote.domain.model.Page

interface PageLocalDataSource {
    suspend fun createPage(title: String)
    suspend fun updatePage(page: Page)
    suspend fun deletePage(id: Long)
    suspend fun getPages(): List<Page>
    suspend fun searchPages(keyword: String): List<Page>
}