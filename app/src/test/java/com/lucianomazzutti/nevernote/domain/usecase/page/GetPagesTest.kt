package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.model.Page
import com.lucianomazzutti.nevernote.domain.repository.PageRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetPagesTest {

    private val repository: PageRepository = mockk()

    private val getPages = GetPages(repository)

    @Test
    fun `should call getPages from PageRepository when invoked is called`() = runBlocking {
        val pagesList = listOf(
            Page(1L, "title1-wololo", listOf()),
            Page(2L, "title2-wololo", listOf())
        )
        prepareScenario(pagesList)

        val pages = getPages()

        coVerify {
            repository.getPages()
        }
        Assert.assertEquals(pagesList, pages)
    }

    private fun prepareScenario(pages: List<Page>) {
        coEvery {
            repository.getPages()
        } returns pages
    }

}