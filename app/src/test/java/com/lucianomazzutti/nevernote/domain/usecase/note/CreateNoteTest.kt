package com.lucianomazzutti.nevernote.domain.usecase.note

import com.lucianomazzutti.nevernote.domain.repository.NoteRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreateNoteTest {

    private val repository: NoteRepository = mockk()

    private val createNote = CreateNote(repository)

    @Test
    fun `should call createNote from NoteRepository when invoked is called`() = runBlocking {
        val title = "title-wololo"
        val description = "description-wololo"
        prepareScenario(title, description) //Preparation

        createNote(title, description) //Execution

        coVerify {
            repository.createNote(title, description) //Validation
        }
    }

    private fun prepareScenario(title: String, description: String) {
        coEvery {
            repository.createNote(title, description)
        } just runs
    }

}