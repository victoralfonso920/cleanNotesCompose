package com.victordevs.composenotes.feature_notes.data.data_source

import androidx.room.*
import com.victordevs.composenotes.feature_notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

// Created by Victor Hernandez on 12/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id:Int): Note?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:Note)

    @Delete
    suspend fun deleteNote(note: Note)
}