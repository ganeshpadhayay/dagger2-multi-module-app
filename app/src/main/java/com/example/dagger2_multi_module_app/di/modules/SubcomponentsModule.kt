package com.example.dagger2_multi_module_app.di.modules

import com.example.login.di.LoginComponent
import dagger.Module

/***
 * this is a module which will register all the sub-components used in the project
 */
@Module(subcomponents = [LoginComponent::class])
class SubcomponentsModule {

}