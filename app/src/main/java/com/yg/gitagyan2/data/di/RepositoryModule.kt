package com.yg.gitagyan2.data.di

import com.yg.gitagyan2.data.remote.GitaApi
import com.yg.gitagyan2.data.repository.FirebaseAuthDataRepositoryImpl
import com.yg.gitagyan2.data.repository.FirebaseDataRepositoryImpl
import com.yg.gitagyan2.data.repository.GitaGyanRepositoryImpl
import com.yg.gitagyan2.domain.remote.GitaApiImpl
import com.yg.gitagyan2.domain.repository.FirebaseAuthDataRepository
import com.yg.gitagyan2.domain.repository.FirebaseDataRepository
import com.yg.gitagyan2.domain.repository.GitaGyanRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Reusable
    internal abstract fun bindFirebaseAuthDataRepository(
        firebaseAuthDataRepository: FirebaseAuthDataRepositoryImpl
    ): FirebaseAuthDataRepository

    @Binds
    @Reusable
    internal abstract fun bindGitaGyanRepository(
        gitaGyanRepository: GitaGyanRepositoryImpl
    ): GitaGyanRepository

    @Binds
    @Reusable
    internal abstract fun bindFirebaseDataRepository(
        firebaseDataRepository: FirebaseDataRepositoryImpl
    ): FirebaseDataRepository

    @Binds
    @Reusable
    internal abstract fun  bindGitaAPI(gitaApiImpl: GitaApiImpl): GitaApi
}