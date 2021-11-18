package com.victordevs.composenotes.feature_notes.presentation.add_edit_note

import android.app.UiAutomation
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.victordevs.composenotes.R
import com.victordevs.composenotes.feature_notes.domain.model.InvalidNoteException
import com.victordevs.composenotes.feature_notes.domain.model.Note
import com.victordevs.composenotes.feature_notes.domain.use_case.NoteUsesCases
import com.victordevs.composenotes.feature_notes.presentation.util.ResourceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// Created by Victor Hernandez on 16/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUsesCases: NoteUsesCases,
    resourceManager: ResourceManager,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val hintTitle = resourceManager.getString(R.string.hint_title)
    private val hintContent = resourceManager.getString(R.string.hint_content)
    private val errorEmpty = resourceManager.getString(R.string.error_save)

    private val _noteTitle = mutableStateOf(
        NoteTextFieldState(
            hint = hintTitle
        )
    )
    val noteTitle: State<NoteTextFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(
        NoteTextFieldState(
            hint = hintContent
        )
    )
    val noteContent: State<NoteTextFieldState> = _noteContent

    private val _noteColor = mutableStateOf(Note.noteColors.random().toArgb())
    val noteColor: State<Int> = _noteColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentNoteId: Int? = null

    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if(noteId != -1){
                viewModelScope.launch {
                    noteUsesCases.getNote(noteId)?.also { note ->
                        currentNoteId = note.id
                        _noteTitle.value = noteTitle.value.copy(
                            text = note.title,
                            isHintVisible = false
                        )
                        _noteContent.value = _noteContent.value.copy(
                            text = note.content,
                            isHintVisible = false
                        )
                        _noteColor.value = note.color

                    }
                }
            }

        }
    }



    fun onEvent(event: AddEditNoteEvent) {
        when (event) {
            is AddEditNoteEvent.EnteredTitle -> {
                _noteTitle.value = _noteTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeTitleFocus -> {
                _noteTitle.value = _noteTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            _noteTitle.value.text.isBlank()
                )
            }
            is AddEditNoteEvent.EnteredContent -> {
                _noteContent.value = _noteContent.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeContentFocus -> {
                _noteContent.value = _noteContent.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            _noteContent.value.text.isBlank()
                )
            }
            is AddEditNoteEvent.ChangeColor -> {
                _noteColor.value = event.color
            }
            is AddEditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        noteUsesCases.addNote(
                            Note(
                                title = noteTitle.value.text,
                                content = noteContent.value.text,
                                timestamp = System.currentTimeMillis(),
                                color = noteColor.value,
                                id = currentNoteId
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveNote)
                    } catch (e: InvalidNoteException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackBar(
                                message = e.message ?: errorEmpty
                            )
                        )
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackBar(val message: String) : UiEvent()
        object SaveNote : UiEvent()
    }
}