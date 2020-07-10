package com.example.dagger2_multi_module_app

import javax.inject.Inject

class StringProvider @Inject constructor() {

    fun provideWelcomeMessage(): String {
        return "Hi, User"
    }

}