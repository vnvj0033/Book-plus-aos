package com.vnvj0033.bookplus.presentation.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf

class GenreSelectionListState {
    val options = mutableStateListOf<String>()
    val selectGenre by mutableStateOf("")
}