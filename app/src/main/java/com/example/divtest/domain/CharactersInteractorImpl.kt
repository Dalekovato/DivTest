package com.example.divtest.domain

import com.example.divtest.data.CharactersApiRepository
import com.example.divtest.data.model.CharactersDomain
import retrofit2.Response
import javax.inject.Inject

class CharactersInteractorImpl @Inject constructor(
    private val characterRepository: CharactersApiRepository
):ICharactersInteractor  {

    override suspend fun getCharactersApi(): Response<List<CharactersDomain>> {
        return characterRepository.getCharactersRepositoryApi()
    }
}