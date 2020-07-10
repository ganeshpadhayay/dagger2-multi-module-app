package com.example.dagger2_multi_module_app

import android.app.Application
import com.example.dagger2_multi_module_app.di.AppComponent
import com.example.dagger2_multi_module_app.di.AppModule
import com.example.dagger2_multi_module_app.di.DaggerAppComponent
import com.example.login.di.LoginComponent
import com.example.login.di.LoginComponentProvider

/***
 * here we will implement all the providers present in the other modules so that their component can be provided by our main app component
 */
class MyApplication : Application(), LoginComponentProvider {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    private fun initDagger(application: MyApplication): AppComponent {
        return DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .build()
    }

    //here we will be listing down all the cross-module component provider methods
    override fun provideLoginComponent(): LoginComponent? {
        return appComponent.loginComponent().create()
    }
}