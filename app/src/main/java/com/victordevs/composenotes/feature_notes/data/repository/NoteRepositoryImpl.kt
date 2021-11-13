package com.victordevs.composenotes.feature_notes.data.repository

import com.victordevs.composenotes.feature_notes.data.data_source.NoteDao
import com.victordevs.composenotes.feature_notes.domain.model.Note
import com.victordevs.composenotes.feature_notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

// Created by Victor Hernandez on 12/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

class NoteRepositoryImpl(
    private val dao:NoteDao
):NoteRepository {
    override fun getNotes(): Flow<List<Note>> = dao.getNotes()

    override suspend fun getNoteByid(id: Int): Note? = dao.getNoteById(id)

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}