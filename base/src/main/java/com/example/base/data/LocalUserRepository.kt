package com.example.base.data

import javax.inject.Inject

class LocalUserRepository @Inject constructor() : UserRepository {
    override fun getUserName(): String {
        return "Ganesh"
    }

    override fun getUserAge(): Int {
        return 25
    }
}