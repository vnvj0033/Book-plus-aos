package com.vnvj0033.allinoneforcats.presentation.presenter

import com.vnvj0033.allinoneforcats.data.repository.CatRepository
import com.vnvj0033.allinoneforcats.domain.model.Cat
import kotlinx.coroutines.flow.single

class CatDetailPresent (
    private val catRepository: CatRepository
) {

    suspend fun getCatList(name: String, callback: (List<Cat>) -> Unit) =
        callback.invoke(catRepository.loadCatList(name).single())

}
