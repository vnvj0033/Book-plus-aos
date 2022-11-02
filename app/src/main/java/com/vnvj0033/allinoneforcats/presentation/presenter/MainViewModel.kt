package com.vnvj0033.allinoneforcats.presentation.presenter

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vnvj0033.allinoneforcats.data.entry.Cat
import com.vnvj0033.allinoneforcats.data.repository.CatRepository
import com.vnvj0033.allinoneforcats.data.repository.FakeCatRepo
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val catRepository: CatRepository = FakeCatRepo()

    val state = MainState()

    fun loadCatList() {
        viewModelScope.launch {
            state.items.addAll(catRepository.getCatList())
        }
    }
}

class MainState {
    val items = mutableStateListOf<Cat>()
    val click = mutableStateOf({_:Cat -> })
}