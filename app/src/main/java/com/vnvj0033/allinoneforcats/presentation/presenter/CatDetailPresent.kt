package com.vnvj0033.allinoneforcats.presentation.presenter

import com.vnvj0033.allinoneforcats.presentation.view.catdetail.CatDetailEvent
import com.vnvj0033.allinoneforcats.data.repository.CatRepository

class CatDetailPresent (
    private val catRepository: CatRepository
) {

    var catDetailEvent: CatDetailEvent? = null

    suspend fun updateCatList(name: String) {
        catRepository.loadCatList(name).collect { list ->
            catDetailEvent?.updateList(list)
        }
    }
}
