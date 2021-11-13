package com.victordevs.composenotes.feature_notes.domain.use_case

import com.victordevs.composenotes.feature_notes.domain.model.Note
import com.victordevs.composenotes.feature_notes.domain.repository.NoteRepository

// Created by Victor Hernandez on 12/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note:Note){
        repository.deleteNote(note)
    }

}