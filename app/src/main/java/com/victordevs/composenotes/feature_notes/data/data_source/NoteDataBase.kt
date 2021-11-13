package com.victordevs.composenotes.feature_notes.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.victordevs.composenotes.feature_notes.domain.model.Note

// Created by Victor Hernandez on 12/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDataBase :RoomDatabase() {

    abstract val noteDao:NoteDao

    companion object{
        const val DATABASE_NAME = "notes_db"
    }

}