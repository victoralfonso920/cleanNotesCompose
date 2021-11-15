package com.victordevs.composenotes.feature_notes.domain.use_case

import com.victordevs.composenotes.feature_notes.domain.model.InvalidNoteException
import com.victordevs.composenotes.feature_notes.domain.model.Note
import com.victordevs.composenotes.feature_notes.domain.repository.NoteRepository

// Created by Victor Hernandez on 13/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }
        repository.insertNote(note)
    }
}