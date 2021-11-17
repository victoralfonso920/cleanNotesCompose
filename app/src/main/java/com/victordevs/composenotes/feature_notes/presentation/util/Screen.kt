package com.victordevs.composenotes.feature_notes.presentation.util

// Created by Victor Hernandez on 17/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

sealed class Screen(val route:String){
    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScreen: Screen("add_edit_note_screen")
}
