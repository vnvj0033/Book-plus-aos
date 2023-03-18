package com.vnvj0033.bookplus.data.repository.user

import com.vnvj0033.bookplus.data.model.UserInfo
import javax.inject.Inject

class FakeUserRepository @Inject constructor() : UserRepository {
    override var userInfo: UserInfo = UserInfo("test_0")
}