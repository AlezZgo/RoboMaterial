package com.alezzgo.robomaterial.core.di

import com.alezzgo.robomaterial.data.Repository
import com.alezzgo.robomaterial.data.SharedPrefs
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface DataModule {

    @Binds
    fun bindSharedPrefs(prefs: SharedPrefs.Base): SharedPrefs

    @Binds
    fun bindRepository(repo: Repository.Base): Repository

}