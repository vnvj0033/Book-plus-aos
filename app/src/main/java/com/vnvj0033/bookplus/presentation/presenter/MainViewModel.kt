package com.vnvj0033.bookplus.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.vnvj0033.bookplus.data.repository.CatRepository
import com.vnvj0033.bookplus.domain.model.toDetailCat
import kotlinx.coroutines.launch

class MainViewModel(
    private val catRepository: CatRepository,
) : ViewModel() {
    val state = MainState()

    fun loadCatList() {
        viewModelScope.launch {
            state.items.addAll(catRepository.getCatList().map {
                it.toDetailCat()
            })
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
