package com.vnvj0033.bookplus.data.repository.user

import javax.inject.Inject

class FakeUserRepository @Inject constructor() : UserRepository {
    override var userInfo: List<String> = listOf()
}