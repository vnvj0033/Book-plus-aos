package com.vnvj0033.allinoneforcats.presentation.presenter

import com.vnvj0033.allinoneforcats.data.repository.CatRepository
import com.vnvj0033.allinoneforcats.data.repository.UserRepository
import com.vnvj0033.allinoneforcats.domain.model.Cat
import com.vnvj0033.allinoneforcats.domain.model.User
import com.vnvj0033.allinoneforcats.domain.usecase.CatUseCase
import com.vnvj0033.allinoneforcats.domain.usecase.UserUseCase

class UserPresenter(
    userRepository: UserRepository,
    catRepository: CatRepository
) {
    private val catUseCase = CatUseCase(catRepository)
    private val userUseCase = UserUseCase(userRepository)

    suspend fun loadData(callback: (List<Cat>, User) -> Unit) {
        val cats = catUseCase.loadCats()
        val user = userUseCase.loadUser(cats)

        callback.invoke(cats, user)
    }
}
