package com.victordevs.composenotes.feature_notes.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState

// Created by Victor Hernandez on 16/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

sealed class AddEditNoteEvent {
    data class EnteredTitle(val value:String):AddEditNoteEvent()
    data class ChangeTitleFocus(val focusState:FocusState):AddEditNoteEvent()
    data class EnteredContent(val value:String):AddEditNoteEvent()
    data class ChangeContentFocus(val focusState:FocusState):AddEditNoteEvent()
    data class ChangeColor(val color:Int):AddEditNoteEvent()
    object SaveNote:AddEditNoteEvent()
}
