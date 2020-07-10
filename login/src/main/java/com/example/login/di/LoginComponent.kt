package com.example.login.di

import com.example.login.view.LoginActivity
import dagger.Subcomponent

/***
 * We can remove the BaseModule::class from here because it is already present in the AppComponent and SubComponent has access to its
 * parent's dependencies
 */
@LoginScope
@Subcomponent(modules = [LoginModule::class /*,BaseModule::class,*/])
interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(loginActivity: LoginActivity)
}