package com.example.divtest.domain

import com.example.divtest.data.model.CharactersDomain
import retrofit2.Response

interface ICharactersInteractor {

    suspend fun getCharactersApi(): Response<List<CharactersDomain>>

}