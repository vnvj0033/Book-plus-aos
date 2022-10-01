package com.vnvj0033.allinoneforcats.ui.catdetil

class CatDetailPresent(
    private val catDetailRepository: CatDetailRepository
) {
    var catDetailEvent: CatDetailEvent? = null

    suspend fun updateCatList(name: String) {
        catDetailRepository.loadCatList(name).collect { list ->
            catDetailEvent?.updateList(list)
        }
    }
}
