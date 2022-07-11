package com.vnvj0033.allinoneforcats.ui.catdetil

class CatDetailPresent(
    private val catDetailEvent: CatDetailEvent,
    private val catDetailRepository: CatDetailRepository
) {

    suspend fun updateCatList(name: String) {
        catDetailRepository.loadCatList(name).collect { list ->
            catDetailEvent.updateList(list)
        }
    }
}
