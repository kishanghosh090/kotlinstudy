package com.example.composecrashcourse

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class SampleViewModel(
    val string: String
): ViewModel() {
    var bgColor by mutableStateOf(Color.White)
        private set

    fun changeBackgroudColor(){
        if (bgColor == Color.Blue){
            bgColor = Color.Red
        }else{
            bgColor = Color.Blue
        }
    }
}