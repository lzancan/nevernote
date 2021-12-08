package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.repository.NoteRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

class DeleteNoteTest {

    private val repository: NoteRepository = mockk()

    private val deleteNote = DeleteNote(repository)

    @Test
    fun `should call deleteNote from NoteRepository when invoked is called`() = runBlocking {
        val id = 1234L
        prepareScenario(id)

        deleteNote(id)

        coVerify {
            repository.deleteNote(id)
        }
    }

    private fun prepareScenario(id: Long) {
        coEvery {
            repository.deleteNote(id)
        } just runs
    }

}