package com.vnvj0033.allinoneforcats.ui.userprofile

import com.vnvj0033.allinoneforcats.model.Cat
import kotlinx.coroutines.flow.collect

class UserPresenter(
    private val userProfileEvent: UserProfileEvent,
    private val userRepository: UserRepository
) {

    fun goToCatDetail(cat: Cat) {
        userProfileEvent.goToCatDetail(cat)
    }

    suspend fun loadCatList() {
        userRepository.loadCats().collect { cats ->
            userProfileEvent.updateCatList(cats)
        }
    }

    suspend fun loadUser() {
        userRepository.loadUser().collect { user ->
            userProfileEvent.updateUser(user)
        }
    }

}
