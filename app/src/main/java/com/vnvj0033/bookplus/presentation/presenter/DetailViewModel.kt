package com.vnvj0033.bookplus.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vnvj0033.bookplus.data.repository.CatRepository
import com.vnvj0033.bookplus.presentation.view.detail.DetailState

class DetailViewModel : ViewModel() {
    val state = DetailState()
}

class DetailViewModelFactory(private val catRepository: CatRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel() as T
        }
        throw IllegalStateException("no ViewModel")
    }
}
