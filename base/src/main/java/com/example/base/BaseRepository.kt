package com.example.base

import javax.inject.Inject

class BaseRepository @Inject constructor() {

    fun getBaseURL(): String {
        return "www.google.com"
    }

}