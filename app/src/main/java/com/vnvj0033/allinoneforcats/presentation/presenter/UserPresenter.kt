package com.vnvj0033.allinoneforcats.presentation.presenter

import com.vnvj0033.allinoneforcats.data.repository.UserRepository
import com.vnvj0033.allinoneforcats.domain.model.Cat
import com.vnvj0033.allinoneforcats.domain.model.User
import kotlinx.coroutines.flow.single

class UserPresenter(
    private val userRepository: UserRepository
) {

    suspend fun loadData(callback: (List<Cat>, User) -> Unit) {
        val cats = userRepository.loadCats().single()
        val user = userRepository.loadUser(cats).single()

        callback.invoke(cats, user)
    }
}
