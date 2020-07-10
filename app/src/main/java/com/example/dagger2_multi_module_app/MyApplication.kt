package com.example.dagger2_multi_module_app

import android.app.Application
import com.example.dagger2_multi_module_app.di.AppComponent
import com.example.dagger2_multi_module_app.di.DaggerAppComponent
import com.example.dagger2_multi_module_app.di.modules.AppModule
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
    override fun provideLoginComponent(): LoginComponent {
        return appComponent.loginComponent().create()
    }
}

/***
Best practices:
The ApplicationComponent should always be in the app module.

Create Dagger components in modules if you need to perform field injection in that module or you need to scope objects for a
specific flow of your application.

For Gradle modules that are meant to be utilities or helpers and don't need to build a graph (that's why you'd need a Dagger
component), create and expose public Dagger modules with @Provides and @Binds methods of those classes that don't support
constructor injection.

To use Dagger in an Android app with dynamic feature modules, use component dependencies to be able to access dependencies
provided by the ApplicationComponent defined in the app module.
 */