package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.model.Page
import com.lucianomazzutti.nevernote.domain.repository.PageRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

class UpdatePageTest {

    private val repository: PageRepository = mockk()

    private val updatePage = UpdatePage(repository)

    @Test
    fun `should call updatePage from PageRepository when invoked is called`() = runBlocking {
        val page = Page(1L, "title-wololo", listOf())
        prepareScenario()

        updatePage(page)

        coVerify {
            repository.updatePage(page)
        }
    }

    private fun prepareScenario() {
        coEvery {
            repository.updatePage(any())
        } just runs
    }

}