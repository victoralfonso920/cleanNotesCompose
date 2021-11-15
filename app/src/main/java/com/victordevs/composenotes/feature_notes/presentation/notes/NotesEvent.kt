package com.victordevs.composenotes.feature_notes.presentation.notes

import com.victordevs.composenotes.feature_notes.domain.model.Note
import com.victordevs.composenotes.feature_notes.domain.util.NoteOrder

// Created by Victor Hernandez on 13/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

sealed class NotesEvent{
    data class Order(val noteOrder:NoteOrder):NotesEvent()
    data class DeleteNote(val note: Note):NotesEvent()
    object Restorenote:NotesEvent()
    object ToggleOrderSection:NotesEvent()
}
