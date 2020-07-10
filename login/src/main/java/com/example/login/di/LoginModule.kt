package com.example.login.di

import com.example.login.repository.ExternalDataRepository
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @LoginScope
    @Provides
    fun provideExternalDataRepository(): ExternalDataRepository {
        return ExternalDataRepository()
    }
}