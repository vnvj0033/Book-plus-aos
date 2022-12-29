package com.vnvj0033.bookplus.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PlatformSelectionState(title: String, imageResource: Int) {
    var title by mutableStateOf("")
    var imageResource by mutableStateOf(0)

    init {
        this.title = title
        this.imageResource = imageResource
    }
}