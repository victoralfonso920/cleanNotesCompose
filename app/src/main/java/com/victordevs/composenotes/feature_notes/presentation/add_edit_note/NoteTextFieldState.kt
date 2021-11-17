package com.victordevs.composenotes.feature_notes.presentation.add_edit_note

// Created by Victor Hernandez on 16/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

data class NoteTextFieldState(
    val text:String = "",
    val hint:String = "",
    val isHintVisible:Boolean = true
)