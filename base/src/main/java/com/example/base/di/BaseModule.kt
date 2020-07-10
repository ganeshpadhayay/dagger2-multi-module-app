package com.example.base.di

import com.example.base.ExternalCommonDataRepository
import dagger.Module
import dagger.Provides

@Module
class BaseModule {

    @Provides
    fun provideExternalCommonDataRepository(): ExternalCommonDataRepository {
        return ExternalCommonDataRepository()
    }
}