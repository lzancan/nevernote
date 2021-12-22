package com.lucianomazzutti.nevernote.data.repository

import com.lucianomazzutti.nevernote.data.datasource.NoteLocalDataSource
import com.lucianomazzutti.nevernote.domain.model.Note
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class NoteRepositoryImplTest {

    private val localDataSource: NoteLocalDataSource = mockk()

    private val repository = NoteRepositoryImpl(localDataSource)

    private val notesList = listOf(
        Note(
            id = 1,
            title = "title1",
            description = "description1"
        ),
        Note(
            id = 2,
            title = "title2",
            description = "description2"
        )
    )

    @Test
    fun `should call createNote from LocalDataSource when createNote from repository is called`() = runBlocking {
        val title = "title-wololo"
        val description = "description-wololo"
        prepareScenario(title, description) //Preparation

        repository.createNote(title, description) //Execution

        coVerify {
            localDataSource.createNote(title, description) //Validation
        }
    }

    @Test
    fun `should call deleteNote from LocalDataSource when deleteNote from repository is called`() = runBlocking {
        val id = 123L
        prepareScenario(id = id)

        repository.deleteNote(id)

        coVerify {
            localDataSource.deleteNote(id)
        }
    }

    @Test
    fun `should call getNotes from LocalDataSource when getNotes from repository is called`() = runBlocking {
        val pageId = 123L
        prepareScenario(pageId = pageId)

        val notes = repository.getNotes(pageId = pageId)

        coVerify {
            localDataSource.getNotes(pageId = pageId)
        }
        Assert.assertEquals(notesList, notes)
    }

    @Test
    fun `should call searchNotes from LocalDataSource when searchNotes from repository is called`() = runBlocking {
        val keyword = "keyword-wololo"
        prepareScenario(keyword = keyword)

        val notes = repository.searchNotes(keyword)

        coVerify {
            localDataSource.searchNotes(keyword)
        }
        Assert.assertEquals(notesList, notes)
    }

    @Test
    fun `should call updateNote from LocalDataSource when updateNote from repository is called`() = runBlocking {
        val note = Note(123L, "title-wololo", "description-wololo")
        prepareScenario(note = note)

        repository.updateNote(note)

        coVerify {
            localDataSource.updateNote(note)
        }
    }

    private fun prepareScenario(
        title: String = "title-wololo",
        description: String = "description-wololo",
        keyword: String = "keyword-wololo",
        id: Long = 1L,
        pageId: Long = 1L,
        note: Note = Note(1L, "title-wololo", "description-wololo")
    ) {
        coEvery {
            localDataSource.createNote(title, description)
        } just runs
        coEvery {
            localDataSource.deleteNote(id)
        } just runs
        coEvery {
            localDataSource.getNotes(pageId)
        } returns notesList
        coEvery {
            localDataSource.searchNotes(keyword)
        } returns notesList
        coEvery {
            localDataSource.updateNote(note)
        } just runs
    }

}