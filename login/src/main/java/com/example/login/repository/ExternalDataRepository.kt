package com.example.login.repository

//suppose this class is not with us, so we can't do constructor injection for this
class ExternalDataRepository {

    fun getExternalURL(): String {
        return " and the external url is www.google.com"
    }

}