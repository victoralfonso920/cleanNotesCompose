package com.victordevs.composenotes.feature_notes.domain.util

// Created by Victor Hernandez on 12/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

sealed class NoteOrder(val orderType: OrderType){
    class Title(orderType: OrderType):NoteOrder(orderType)
    class Date(orderType: OrderType):NoteOrder(orderType)
    class Color(orderType: OrderType):NoteOrder(orderType)
}
