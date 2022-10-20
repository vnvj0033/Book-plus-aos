package com.vnvj0033.allinoneforcats.presentation.presenter

import com.vnvj0033.allinoneforcats.domain.model.Cat
import com.vnvj0033.allinoneforcats.presentation.view.userprofile.UserProfileEvent
import com.vnvj0033.allinoneforcats.data.repository.UserRepository

class UserPresenter(
    private val userRepository: UserRepository
) {
    var userProfileEvent: UserProfileEvent? = null

    fun goToCatDetail(cat: Cat) {
        userProfileEvent?.goToCatDetail(cat)
    }

    suspend fun loadData() {
        userRepository.loadCats().collect { cats ->
            userRepository.loadUser(cats).collect { user ->

                userProfileEvent?.updateUser(user)
                userProfileEvent?.updateCatList(cats)
            }
        }
    }
}
