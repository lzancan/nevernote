package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.model.Note
import com.lucianomazzutti.nevernote.domain.repository.NoteRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.runBlocking
import org.junit.Test

class UpdateNoteTest {

    private val repository: NoteRepository = mockk()

    private val updateNote = UpdateNote(repository)

    @Test
    fun `should call updateNote from NoteRepository when invoked is called`() = runBlocking {
        val note = Note(1L, "title-wololo", "description-wololo")
        prepareScenario(note)

        updateNote(note)

        coVerify {
            repository.updateNote(note)
        }
    }

    private fun prepareScenario(note: Note) {
        coEvery {
            repository.updateNote(note)
        } just runs
    }

}