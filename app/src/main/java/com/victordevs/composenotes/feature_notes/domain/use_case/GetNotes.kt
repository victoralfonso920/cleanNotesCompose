package com.victordevs.composenotes.feature_notes.domain.use_case

import com.victordevs.composenotes.feature_notes.domain.model.Note
import com.victordevs.composenotes.feature_notes.domain.repository.NoteRepository
import com.victordevs.composenotes.feature_notes.domain.util.NoteOrder
import com.victordevs.composenotes.feature_notes.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*

// Created by Victor Hernandez on 12/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

class GetNotes(
    private val repository:NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>>{
        return  repository.getNotes().map { notes ->
            when(noteOrder.orderType){
                is OrderType.Ascending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase(Locale.getDefault()) }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase(Locale.getDefault()) }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}