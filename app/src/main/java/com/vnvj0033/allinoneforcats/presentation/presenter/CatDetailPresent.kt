package com.vnvj0033.allinoneforcats.presentation.presenter

import com.vnvj0033.allinoneforcats.data.repository.CatRepository
import com.vnvj0033.allinoneforcats.domain.model.Cat
import kotlinx.coroutines.flow.single

class CatDetailPresent (
    private val catRepository: CatRepository
) {

    var catPair: Pair<String, List<Cat>>? = null

    suspend fun getCatList(name: String, callback: (List<Cat>) -> Unit) {
        if (catPair != null && catPair?.first == name) {
            callback.invoke(catPair!!.second)
        } else {
            val list = catRepository.loadCatList(name).single()
            catPair = Pair(name, list)
            callback.invoke(list)

        }
    }

}
