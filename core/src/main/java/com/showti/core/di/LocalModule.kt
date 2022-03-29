package com.showti.core.di

import android.content.Context
import com.showti.core.data.persistance.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext:Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideDogDao(db:AppDatabase) = db.dogDao()
}