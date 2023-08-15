package com.example.ypheadlines.di

import com.example.ypheadlines.data.repository.LocalUserManagerRepositoryImpl
import com.example.ypheadlines.domain.repository.LocalUserManagerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UserManagerModule {

    @Singleton
    @Binds
    fun bindLocalUserManagerRepository(impl: LocalUserManagerRepositoryImpl): LocalUserManagerRepository

}