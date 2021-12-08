package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.model.Page
import com.lucianomazzutti.nevernote.domain.repository.PageRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class SearchPagesTest {

    private val repository: PageRepository = mockk()

    private val searchPages = SearchPages(repository)

    @Test
    fun `should call searchPages from PageRepository when invoked is called`() = runBlocking {
        val keyword = "keyword-wololo"
        val pagesList = listOf(
            Page(1L, "title1-wololo", listOf()),
            Page(2L, "title2-wololo", listOf())
        )
        prepareScenario(pagesList)

        val pages = searchPages(keyword)

        coVerify {
            repository.searchPages(keyword)
        }
        Assert.assertEquals(pagesList, pages)
    }

    private fun prepareScenario(pages: List<Page>) {
        coEvery {
            repository.searchPages(any())
        } returns pages
    }

}