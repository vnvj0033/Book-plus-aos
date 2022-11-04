package com.vnvj0033.allinoneforcats.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vnvj0033.allinoneforcats.data.repository.CatRepository
import com.vnvj0033.allinoneforcats.presentation.view.main.MainState
import kotlinx.coroutines.launch

class MainViewModel(
    private val catRepository: CatRepository,
) : ViewModel() {
    val state = MainState()

    fun loadCatList() {
        viewModelScope.launch {
            state.items.addAll(catRepository.getCatList())
        }
    }
}

class MainViewModelFactory(private val catRepository: CatRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(catRepository) as T
        }
        throw IllegalStateException("no ViewModel")
    }
}
