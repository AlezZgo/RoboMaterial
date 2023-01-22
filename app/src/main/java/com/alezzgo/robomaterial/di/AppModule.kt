package com.alezzgo.robomaterial.di

import android.content.Context
import com.alezzgo.robomaterial.core.ManageResources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideManageResources(
        @ApplicationContext context: Context
    ): ManageResources = ManageResources.Base(context)


}