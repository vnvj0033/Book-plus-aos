package com.vnvj0033.allinoneforcats.domain.usecase

import com.vnvj0033.allinoneforcats.data.repository.CatRepository
import com.vnvj0033.allinoneforcats.domain.model.Cat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.single

class CatUseCase(private val catRepository: CatRepository) {

    suspend fun loadCats(name: String): List<Cat> {
        return catRepository.loadCatList(name).single()
    }

    suspend fun loadCats() =
        flowOf(ArrayList<Cat>().apply { for (i in 0..99) add(Cat()) }).single()
}
