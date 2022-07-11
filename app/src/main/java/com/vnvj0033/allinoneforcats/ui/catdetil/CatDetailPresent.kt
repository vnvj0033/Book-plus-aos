package com.vnvj0033.allinoneforcats.ui.catdetil

import com.vnvj0033.allinoneforcats.model.Cat

class CatDetailPresent(
    private val catDetailEvent: CatDetailEvent,
    private val catDetailRepository: CatDetailRepository
) {
    suspend fun updateCatProfile(cat: Cat) {

        if (cat.name.isNotEmpty()) {
            catDetailEvent.updateCat(cat)
        } else {
            catDetailRepository.loadCat().collect { dbCat ->
                catDetailEvent.updateCat(dbCat)
            }
        }

    }

    suspend fun updateCatList() {
        catDetailRepository.loadCatList().collect { list ->
            catDetailEvent.updateList(list)
        }
    }
}
