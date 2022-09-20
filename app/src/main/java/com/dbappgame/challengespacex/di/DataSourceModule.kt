package com.dbappgame.challengespacex.di

import com.dbappgame.challengespacex.data.LaunchNetDataSource
import com.dbappgame.challengespacex.data.LaunchRetrofitDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun provideDataSource(dataSourceImp: LaunchRetrofitDataSourceImp): LaunchNetDataSource


}