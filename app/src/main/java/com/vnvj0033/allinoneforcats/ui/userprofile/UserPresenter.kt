package com.vnvj0033.allinoneforcats.ui.userprofile

import com.vnvj0033.allinoneforcats.model.Cat

class UserPresenter(
    private val userProfileEvent: UserProfileEvent,
    private val userRepository: UserRepository
) {

    fun goToCatDetail(cat: Cat) {
        userProfileEvent.goToCatDetail(cat)
    }

    suspend fun loadData() {
        userRepository.loadCats().collect { cats ->
            userRepository.loadUser(cats).collect { user ->

                userProfileEvent.updateUser(user)
                userProfileEvent.updateCatList(cats)
            }
        }
    }
}
