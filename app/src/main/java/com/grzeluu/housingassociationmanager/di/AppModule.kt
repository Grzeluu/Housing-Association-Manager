package com.grzeluu.housingassociationmanager.di

import com.grzeluu.housingassociationmanager.data.repository.UserRepository
import com.grzeluu.housingassociationmanager.data.repository.UserRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository {
        return UserRepositoryImp()
    }

}