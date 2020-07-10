package com.example.base.data

import javax.inject.Inject

class RemoteUserRepository @Inject constructor() : UserRepository {
    override fun getUserName(): String {
        return "Ganesh Network"
    }

    override fun getUserAge(): Int {
        return 26
    }
}