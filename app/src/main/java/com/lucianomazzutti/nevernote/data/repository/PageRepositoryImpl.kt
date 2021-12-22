package com.lucianomazzutti.nevernote.data.repository

import com.lucianomazzutti.nevernote.data.datasource.PageLocalDataSource
import com.lucianomazzutti.nevernote.domain.model.Page
import com.lucianomazzutti.nevernote.domain.repository.PageRepository

class PageRepositoryImpl constructor(
    private val pageLocalDataSource: PageLocalDataSource
): PageRepository {
    override suspend fun createPage(title: String) {
        pageLocalDataSource.createPage(title)
    }

    override suspend fun updatePage(page: Page) {
        pageLocalDataSource.updatePage(page)
    }

    override suspend fun deletePage(id: Long) {
        pageLocalDataSource.deletePage(id)
    }

    override suspend fun getPages(): List<Page> {
        return pageLocalDataSource.getPages()
    }

    override suspend fun searchPages(keyword: String): List<Page> {
        return pageLocalDataSource.searchPages(keyword)
    }
}