package com.example.dagger2_multi_module_app.di

import com.example.base.di.BaseModule
import com.example.dagger2_multi_module_app.di.modules.AppModule
import com.example.dagger2_multi_module_app.di.modules.NetworkModule
import com.example.dagger2_multi_module_app.di.modules.SubcomponentsModule
import com.example.dagger2_multi_module_app.di.viewmodel.MainViewModelModule
import com.example.dagger2_multi_module_app.view.MainActivity
import com.example.login.di.LoginComponent
import dagger.Component
import javax.inject.Singleton

/***
 * this is a singleton AppComponent which will be used by all components in the app
 */
@Singleton
@Component(modules = [AppModule::class, SubcomponentsModule::class, BaseModule::class, NetworkModule::class, MainViewModelModule::class])
interface AppComponent {

    //register all the sub-components here
    fun loginComponent(): LoginComponent.Factory

    //injection in the activities, services, broadcast receivers, and content providers belonging to the app module
    fun inject(mainActivity: MainActivity)
}