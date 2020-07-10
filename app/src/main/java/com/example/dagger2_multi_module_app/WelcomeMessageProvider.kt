package com.example.dagger2_multi_module_app

import javax.inject.Inject

class WelcomeMessageProvider @Inject constructor() {

    fun provideWelcomeMessage(): String {
        return "Hi, User"
    }

}