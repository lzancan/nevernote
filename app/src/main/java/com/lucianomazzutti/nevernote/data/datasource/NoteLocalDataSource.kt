package com.lucianomazzutti.nevernote.data.datasource

import com.lucianomazzutti.nevernote.domain.model.Note

interface NoteLocalDataSource {
    suspend fun createNote(title: String, description: String)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(id: Long)
    suspend fun getNotes(pageId: Long): List<Note>
    suspend fun searchNotes(keyword: String): List<Note>
}