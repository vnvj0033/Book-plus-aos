package com.vnvj0033.bookplus.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class GenreSelectionListState {
    val options = mutableStateListOf<String>()
    var selectGenre by mutableStateOf("")
}