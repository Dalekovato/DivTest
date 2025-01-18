package com.example.divtest.data

import com.example.divtest.data.networkDto.CharacterResponseNetwork
import retrofit2.Response
import retrofit2.http.GET

interface ICharactersApiService {

   @GET("character")
   suspend fun getCharacter(): Response<CharacterResponseNetwork>

}