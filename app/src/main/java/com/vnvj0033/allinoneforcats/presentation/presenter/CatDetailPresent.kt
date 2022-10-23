package com.vnvj0033.allinoneforcats.presentation.presenter

import com.vnvj0033.allinoneforcats.data.repository.CatRepository
import com.vnvj0033.allinoneforcats.domain.model.Cat
import kotlinx.coroutines.flow.single

class CatDetailPresent (
    private val catRepository: CatRepository
) {

    // TODO: 캐시 메모리 구현 되어있는데 필요한지?
    private var catPair = Pair<String, List<Cat>>("", ArrayList())

    suspend fun getCatList(name: String, callback: (List<Cat>) -> Unit) {
        if (catPair.first == name) {
            callback.invoke(catPair.second)
        } else {
            val list = catRepository.loadCatList(name).single()
            catPair = Pair(name, list)
            callback.invoke(list)
        }
    }

}
