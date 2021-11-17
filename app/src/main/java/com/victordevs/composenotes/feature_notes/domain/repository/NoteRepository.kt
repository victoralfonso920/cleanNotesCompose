package com.victordevs.composenotes.feature_notes.domain.repository

import com.victordevs.composenotes.feature_notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

// Created by Victor Hernandez on 12/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id:Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

}