package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.repository.PageRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreatePageTest {

    private val repository: PageRepository = mockk()

    private val createPage = CreatePage(repository)

    @Test
    fun `should call createPage from PageRepository when invoked is called`() = runBlocking {
        val title = "title-wololo"
        prepareScenario(title)

        createPage(title)

        coVerify {
            repository.createPage(title)
        }
    }

    private fun prepareScenario(title: String) {
        coEvery {
            repository.createPage(title)
        } just runs
    }

}