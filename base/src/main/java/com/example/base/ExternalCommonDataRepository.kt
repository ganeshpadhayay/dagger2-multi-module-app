package com.example.base

/***
 * Say, this class belongs to a 3rd party library and constructor injection is not possible then we should use a public dagger module
 * so that other app modules can use this
 */
class ExternalCommonDataRepository {

    fun getExternalCommonAPIURL():String{
        return "www.microsoft.com"
    }
}