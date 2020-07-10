package com.example.login.di.viewmodel

import androidx.lifecycle.ViewModel
import com.example.login.view.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Named

@Module
abstract class LoginViewModelModule {

    @Binds
    @IntoMap
    @Named("login-map")
    @LoginViewModelKey(LoginViewModel::class)
    abstract fun loginViewModel(loginViewModel: LoginViewModel): ViewModel
}