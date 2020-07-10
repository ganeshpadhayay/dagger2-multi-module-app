package com.example.login.di.viewmodel

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class LoginViewModelKey(val value: KClass<out ViewModel>)