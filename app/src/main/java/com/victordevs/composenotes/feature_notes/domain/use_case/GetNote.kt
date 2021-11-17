package com.victordevs.composenotes.feature_notes.domain.use_case

import com.victordevs.composenotes.feature_notes.domain.repository.NoteRepository

// Created by Victor Hernandez on 16/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun  invoke(id:Int) =   repository.getNoteById(id)
}