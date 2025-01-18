package com.example.divtest.domain.mapper

import com.example.divtest.data.networkDto.CharacterDtoNetwork

class CharactersMapperNetwork(characterDto: List<CharacterDtoNetwork?>?) {

    val character by lazy {
        characterDto?.mapNotNull {
            it?.let { CharacterMapperNetwork(it).char }
        } ?: emptyList()
    }
}