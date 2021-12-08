package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.model.Note
import com.lucianomazzutti.nevernote.domain.repository.NoteRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class SearchNotesTest {

    private val repository: NoteRepository = mockk()

    private val searchNotes = SearchNotes(repository)

    @Test
    fun `should call searchNotes from NoteRepository when invoked is called`() = runBlocking {
        val keyword = "keyword-wololo"
        val notesList = listOf(
            Note(1L, "title1-wololo", "description1-wololo"),
            Note(2L, "title2-wololo", "description2-wololo")
        )
        prepareScenario(notesList)

        val notes = searchNotes(keyword)

        coVerify {
            repository.searchNotes(keyword)
        }
        Assert.assertEquals(notesList, notes)
    }

    private fun prepareScenario(notes: List<Note>) {
        coEvery {
            repository.searchNotes(any())
        } returns notes
    }

}