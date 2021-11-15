package com.victordevs.composenotes.feature_notes.presentation.notes

import com.victordevs.composenotes.feature_notes.domain.model.Note
import com.victordevs.composenotes.feature_notes.domain.util.NoteOrder
import com.victordevs.composenotes.feature_notes.domain.util.OrderType

// Created by Victor Hernandez on 13/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteorder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible:Boolean = false
)
