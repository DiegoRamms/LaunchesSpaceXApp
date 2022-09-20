package com.dbappgame.challengespacex.di

import com.dbappgame.challengespacex.data.repository.LaunchRepository
import com.dbappgame.challengespacex.data.repository.LaunchRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideLaunchRepository(repositoryImp: LaunchRepositoryImp): LaunchRepository
}