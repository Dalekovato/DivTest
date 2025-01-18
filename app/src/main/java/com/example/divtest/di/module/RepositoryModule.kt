package com.example.divtest.di.module

import com.example.divtest.data.CharactersApiRepository
import com.example.divtest.domain.CharactersInteractorImpl
import com.example.divtest.domain.ICharactersInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideICharactersInteractor(charactersApiRepository: CharactersApiRepository): ICharactersInteractor {
        return CharactersInteractorImpl(charactersApiRepository)
    }

}