package com.victordevs.composenotes.feature_notes.domain.util

// Created by Victor Hernandez on 12/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

sealed class OrderType{
    object Ascending:OrderType()
    object Descending:OrderType()
}
