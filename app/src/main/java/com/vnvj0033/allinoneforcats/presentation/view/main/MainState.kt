package com.vnvj0033.allinoneforcats.presentation.view.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.vnvj0033.allinoneforcats.data.entry.CatEntry
import com.vnvj0033.allinoneforcats.domain.model.DetailCat


class MainState {
    val items = mutableStateListOf<DetailCat>()
    var click by mutableStateOf({ _: DetailCat -> })
}