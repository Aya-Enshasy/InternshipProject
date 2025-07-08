package com.example.finalproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BottomBarViewModel : ViewModel() {
    var selectedIndex by mutableStateOf(0)
}
