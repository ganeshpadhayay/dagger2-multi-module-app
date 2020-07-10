package com.example.login.repository

import com.example.base.BaseRepository
import com.example.base.ExternalCommonDataRepository
import javax.inject.Inject

class LoginRepository @Inject constructor() {

    //this belongs to the login module
    @Inject
    lateinit var externalDataRepository: ExternalDataRepository

    //these belong to the base module
    @Inject
    lateinit var baseRepository: BaseRepository

    @Inject
    lateinit var externalCommonDataRepository: ExternalCommonDataRepository

    fun getStringFromLoginRepository(): String {
        return "Username is Ganesh" + externalDataRepository.getExternalURL() + " and base url is " + baseRepository.getBaseURL() + " and external url is " + externalCommonDataRepository.getExternalCommonAPIURL()
    }
}