package com.vnvj0033.allinoneforcats.presentation.presenter

import androidx.lifecycle.ViewModel
import com.vnvj0033.allinoneforcats.data.entry.Cat

class MainPresenter : ViewModel() {
    val cats: List<Cat>? = null
    fun loadCatList(cats: (List<Cat>) -> Boolean) {

    }
}