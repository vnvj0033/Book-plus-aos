package com.vnvj0033.allinoneforcats.domain.usecase

import com.vnvj0033.allinoneforcats.data.repository.UserRepository
import com.vnvj0033.allinoneforcats.domain.model.Cat
import com.vnvj0033.allinoneforcats.domain.model.User
import kotlinx.coroutines.flow.single

class UserUseCase(private val userRepository: UserRepository) {

    suspend fun loadUser(cats: List<Cat>): User {
        return userRepository.loadUser(cats).single()
    }
}
