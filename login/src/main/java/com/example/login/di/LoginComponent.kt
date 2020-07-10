package com.example.login.di

import com.example.login.LoginActivity
import dagger.Subcomponent

@LoginScope
@Subcomponent(modules = [LoginModule::class])
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(loginActivity: LoginActivity)

}