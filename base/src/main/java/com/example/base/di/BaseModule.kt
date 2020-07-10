package com.example.base.di

import com.example.base.ExternalCommonDataRepository
import com.example.base.data.LocalUserRepository
import com.example.base.data.RemoteUserRepository
import com.example.base.data.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

/***
 * error: A @Module may not contain both non-static and abstract binding methods
 *
 * if you use Binds with non-static Provides then you get the above error so let us make our provides a static because we are not
 * using any class variables anyway, if we were using any class variables then we would have to create a separate module for our Binds
 * dependency and a separate module for non static Provides
 */
@Module
abstract class BaseModule {

    companion object {
        @Provides
        fun provideExternalCommonDataRepository(): ExternalCommonDataRepository {
            return ExternalCommonDataRepository()
        }
    }

    @Binds
    @Named("local")
    abstract fun bindLocalUserRepository(localUserRepository: LocalUserRepository): UserRepository

    @Binds
    @Named("remote")
    abstract fun bindRemoteUserRepository(remoteUserRepository: RemoteUserRepository): UserRepository
}