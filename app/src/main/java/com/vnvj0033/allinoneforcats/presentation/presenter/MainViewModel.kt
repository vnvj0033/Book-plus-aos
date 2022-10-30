package com.vnvj0033.allinoneforcats.presentation.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vnvj0033.allinoneforcats.data.entry.Cat
import com.vnvj0033.allinoneforcats.data.repository.CatRepository
import com.vnvj0033.allinoneforcats.data.repository.FakeCatRepo

class MainViewModel : ViewModel() {

    private val catRepository: CatRepository = FakeCatRepo()

    private val _cats = MutableLiveData<List<Cat>>()
    val cats: LiveData<List<Cat>>
        get() = _cats

    suspend fun loadCatList() {
        _cats.postValue(catRepository.getCatList())
    }
}