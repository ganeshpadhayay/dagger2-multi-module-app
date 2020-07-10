package com.example.login.repository

import com.example.base.BaseRepository
import com.example.base.ExternalCommonDataRepository
import com.example.base.data.RemoteUserRepository
import com.example.base.data.UserRepository
import javax.inject.Inject
import javax.inject.Named

class LoginRepository @Inject constructor() {

    //this belongs to the login module
    @Inject
    lateinit var externalDataRepository: ExternalDataRepository

    //these belong to the base module
    @Inject
    lateinit var baseRepository: BaseRepository

    @Inject
    lateinit var externalCommonDataRepository: ExternalCommonDataRepository

    @Inject
    @Named("remote")
    lateinit var remoteUserRepository: UserRepository

    fun getStringFromLoginRepository(): String {
        return "Username is Ganesh" + externalDataRepository.getExternalURL() + " and base url is " + baseRepository.getBaseURL() +
                " and external url is " + externalCommonDataRepository.getExternalCommonAPIURL() +
                " and local user id " + remoteUserRepository.getUserName() + remoteUserRepository.getUserAge()
    }
}