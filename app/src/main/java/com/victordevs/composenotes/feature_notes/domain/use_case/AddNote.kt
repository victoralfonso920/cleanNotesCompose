package com.victordevs.composenotes.feature_notes.domain.use_case

import com.victordevs.composenotes.R
import com.victordevs.composenotes.feature_notes.domain.model.InvalidNoteException
import com.victordevs.composenotes.feature_notes.domain.model.Note
import com.victordevs.composenotes.feature_notes.domain.repository.NoteRepository
import com.victordevs.composenotes.feature_notes.presentation.util.ResourceManager

// Created by Victor Hernandez on 13/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

class AddNote(
    private val repository: NoteRepository,
    private val resourceManager: ResourceManager
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException(resourceManager.getString(R.string.error_empty))
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException(resourceManager.getString(R.string.error_empty))
        }
        repository.insertNote(note)
    }
}