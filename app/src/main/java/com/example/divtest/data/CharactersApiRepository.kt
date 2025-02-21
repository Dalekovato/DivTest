package com.example.divtest.data

import com.example.divtest.data.networkDto.CharacterDtoNetwork
import com.example.divtest.data.networkDto.LocationDtoNetwork
import com.example.divtest.data.networkDto.OriginDtoNetwork
import com.example.divtest.data.networkDto.StatusImgNetwork
import com.example.divtest.data.mapper.CharactersMapperNetwork
import com.example.divtest.data.model.CharactersDomain
import retrofit2.Response
import javax.inject.Inject

class CharactersApiRepository @Inject constructor(
    private val serviceApiCharacter: ICharactersApiService,
) {

    suspend fun getCharactersRepositoryApi(): Response<List<CharactersDomain>> {

        val response = serviceApiCharacter.getCharacter()
        val defList = listOf( CharacterDtoNetwork(
            0,"",
            StatusImgNetwork.UNKNOWN,
            "",
            "",
            "",
            OriginDtoNetwork("",""),
            LocationDtoNetwork("",""),
            "",
            emptyList(),
            "",
            ""))

        return Response.success(
            CharactersMapperNetwork(
                response.body()?.results ?: defList
            ).character
        )
    }
}