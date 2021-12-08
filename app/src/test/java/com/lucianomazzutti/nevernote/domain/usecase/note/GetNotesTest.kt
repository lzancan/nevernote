package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.model.Note
import com.lucianomazzutti.nevernote.domain.repository.NoteRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetNotesTest {

    private val repository: NoteRepository = mockk()

    private val getNotes = GetNotes(repository)

    @Test
    fun `should call getNotes from NoteRepository when invoked is called`() = runBlocking {
        val pageId = 123L
        val notesList = listOf(
            Note(1L, "title1-wololo", "description1-wololo"),
            Note(2L, "title2-wololo", "description2-wololo")
        )
        prepareScenario(notesList)

        val notes = getNotes(pageId)

        coVerify {
            repository.getNotes(pageId)
        }
        Assert.assertEquals(notesList, notes)
    }

    private fun prepareScenario(notes: List<Note>) {
        coEvery {
            repository.getNotes(any())
        } returns notes
    }

}