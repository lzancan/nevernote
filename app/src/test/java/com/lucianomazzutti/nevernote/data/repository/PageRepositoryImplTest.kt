package com.lucianomazzutti.nevernote.data.repository

import com.lucianomazzutti.nevernote.data.datasource.PageLocalDataSource
import com.lucianomazzutti.nevernote.domain.model.Note
import com.lucianomazzutti.nevernote.domain.model.Page
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class PageRepositoryImplTest {

    private val localDataSource: PageLocalDataSource = mockk()

    private val repository = PageRepositoryImpl(localDataSource)

    private val pagesList = listOf(
        Page(
            id = 1,
            title = "title1",
            listOf()
        ),
        Page(
            id = 2,
            title = "title2",
            listOf()
        )
    )

    @Test
    fun `should call createPage from LocalDataSource when createPage from repository is called`() = runBlocking {
        val title = "title-wololo"
        prepareScenario(title) //Preparation

        repository.createPage(title) //Execution

        coVerify {
            localDataSource.createPage(title) //Validation
        }
    }

    @Test
    fun `should call deletePage from LocalDataSource when deletePage from repository is called`() = runBlocking {
        val id = 123L
        prepareScenario(id = id)

        repository.deletePage(id)

        coVerify {
            localDataSource.deletePage(id)
        }
    }

    @Test
    fun `should call getPages from LocalDataSource when getPages from repository is called`() = runBlocking {
        prepareScenario()

        val pages = repository.getPages()

        coVerify {
            localDataSource.getPages()
        }
        Assert.assertEquals(pagesList, pages)
    }

    @Test
    fun `should call searchPages from LocalDataSource when searchPages from repository is called`() = runBlocking {
        val keyword = "keyword-wololo"
        prepareScenario(keyword = keyword)

        val pages = repository.searchPages(keyword)

        coVerify {
            localDataSource.searchPages(keyword)
        }
        Assert.assertEquals(pagesList, pages)
    }

    @Test
    fun `should call updatePage from LocalDataSource when updatePage from repository is called`() = runBlocking {
        val page = Page(123L, "title-wololo", listOf())
        prepareScenario(page = page)

        repository.updatePage(page)

        coVerify {
            localDataSource.updatePage(page)
        }
    }

    private fun prepareScenario(
        title: String = "title-wololo",
        keyword: String = "keyword-wololo",
        id: Long = 1L,
        page: Page = Page(1L, "title-wololo", listOf())
    ) {
        coEvery {
            localDataSource.createPage(title)
        } just runs
        coEvery {
            localDataSource.deletePage(id)
        } just runs
        coEvery {
            localDataSource.getPages()
        } returns pagesList
        coEvery {
            localDataSource.searchPages(keyword)
        } returns pagesList
        coEvery {
            localDataSource.updatePage(page)
        } just runs
    }

}