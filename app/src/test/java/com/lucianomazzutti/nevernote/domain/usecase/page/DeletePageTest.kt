package com.lucianomazzutti.nevernote.domain.usecase.page

import com.lucianomazzutti.nevernote.domain.repository.PageRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

class DeletePageTest {

    private val repository: PageRepository = mockk()

    private val deletePage = DeletePage(repository)

    @Test
    fun `should call deletePage from PageRepository when invoked is called`() = runBlocking {
        val id = 1234L
        prepareScenario()

        deletePage(id)

        coVerify {
            repository.deletePage(id)
        }
    }

    private fun prepareScenario() {
        coEvery {
            repository.deletePage(any())
        } just runs
    }

}