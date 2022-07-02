package com.vnvj0033.allinoneforcats.ui.catdetil

import kotlinx.coroutines.flow.collect

class CatDetailPresent(
    private val catDetailEvent: CatDetailEvent,
    private val catDetailRepository: CatDetailRepository
) {
    suspend fun updateCatProfile() {
        catDetailRepository.loadCat().collect { cat ->
            catDetailEvent.updateCat(cat)
        }
    }

    fun updateCatList() {
        catDetailRepository.loadCatList().collect { list ->
            catDetailEvent.updateList(list)
        }
    }
}
