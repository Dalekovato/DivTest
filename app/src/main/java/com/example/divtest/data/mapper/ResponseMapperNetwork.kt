package com.example.divtest.data.mapper

import com.example.divtest.data.networkDto.CharacterResponseNetwork
import com.example.divtest.data.model.ResponseDomain

class ResponseMapperNetwork(characterResp: CharacterResponseNetwork) {

    val respopnse by lazy {
        ResponseDomain(
            info = InfoMapperNetwork(characterResp.info).info,
            listCharacters = CharactersMapperNetwork(characterResp.results).character
        )
    }
}