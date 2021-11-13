package com.victordevs.composenotes.feature_notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.victordevs.composenotes.ui.theme.*

// Created by Victor Hernandez on 12/11/21.
// Proyect Compose Notes
//contact victoralfonso920@gmail.com

@Entity
data class Note(
    val title:String,
    val content:String,
    val timestamp:Long,
    val color:Int,
    @PrimaryKey val id:Int? = null
){
    companion object{
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink,Yellow)
    }
}
