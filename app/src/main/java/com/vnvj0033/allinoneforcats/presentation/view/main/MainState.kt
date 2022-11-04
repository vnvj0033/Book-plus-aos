package com.vnvj0033.allinoneforcats.presentation.view.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.vnvj0033.allinoneforcats.data.entry.Cat


class MainState {
    val items = mutableStateListOf<Cat>()
    var click by mutableStateOf({ _: Cat -> })
}