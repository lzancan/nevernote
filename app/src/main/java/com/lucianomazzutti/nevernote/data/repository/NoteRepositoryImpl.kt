package com.lucianomazzutti.nevernote.data.repository

import com.lucianomazzutti.nevernote.data.datasource.NoteLocalDataSource
import com.lucianomazzutti.nevernote.domain.model.Note
import com.lucianomazzutti.nevernote.domain.repository.NoteRepository

class NoteRepositoryImpl constructor(
    private val noteLocalDataSource: NoteLocalDataSource
): NoteRepository {
    override suspend fun createNote(title: String, description: String) {
        noteLocalDataSource.createNote(title, description)
    }

    override suspend fun updateNote(note: Note) {
        noteLocalDataSource.updateNote(note)
    }

    override suspend fun deleteNote(id: Long) {
        noteLocalDataSource.deleteNote(id)
    }

    override suspend fun getNotes(pageId: Long): List<Note> {
        return noteLocalDataSource.getNotes(pageId)
    }

    override suspend fun searchNotes(keyword: String): List<Note> {
        return noteLocalDataSource.searchNotes(keyword)
    }
}