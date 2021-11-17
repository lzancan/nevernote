package com.lucianomazzutti.nevernote.domain.repository

import com.lucianomazzutti.nevernote.domain.model.Note

interface NoteRepository {
    suspend fun createNote(title: String, description: String)
    suspend fun updateNote(note: Note)
    suspend fun deleteNote(id: Long)
    suspend fun getNotes(pageId: Long): List<Note>
    suspend fun searchNotes(keyword: String): List<Note>
}