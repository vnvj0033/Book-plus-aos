package com.vnvj0033.allinoneforcats.presentation.presenter

import com.vnvj0033.allinoneforcats.domain.model.Cat
import com.vnvj0033.allinoneforcats.presentation.view.userprofile.UserProfileEvent
import com.vnvj0033.allinoneforcats.data.repository.UserRepository
import kotlinx.coroutines.flow.single

class UserPresenter(
    private val userRepository: UserRepository
) {
    var userProfileEvent: UserProfileEvent? = null

    fun goToCatDetail(cat: Cat) {
        userProfileEvent?.goToCatDetail(cat)
    }

    suspend fun loadData() {
        val cats = userRepository.loadCats().single()
        val user = userRepository.loadUser(cats).single()

        userProfileEvent?.updateUser(user)
        userProfileEvent?.updateCatList(cats)
    }
}
