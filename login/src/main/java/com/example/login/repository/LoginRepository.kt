package com.example.login.repository

import javax.inject.Inject

class LoginRepository @Inject constructor() {

    @Inject
    lateinit var externalDataRepository: ExternalDataRepository

    fun getStringFromLoginRepository(): String {
        return "Username is Ganesh" + externalDataRepository.getExternalURL()
    }

    fun getStringFromOnlyLoginRepository(): String {
        return "Username is Ganesh"
    }

}