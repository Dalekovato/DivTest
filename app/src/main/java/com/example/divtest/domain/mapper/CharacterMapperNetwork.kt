package com.example.divtest.domain.mapper

import com.example.divtest.data.networkDto.CharacterDtoNetwork
import com.example.divtest.data.networkDto.StatusImgNetwork
import com.example.divtest.domain.model.CharactersDomain

class CharacterMapperNetwork(characterDto: CharacterDtoNetwork) {

    val char by lazy {
        CharactersDomain(
            id = characterDto.id ?: 0,
            name = characterDto.name.orEmpty(),
            status = characterDto.status ?: StatusImgNetwork.UNKNOWN,
            species = characterDto.species.orEmpty(),
            type = characterDto.type.orEmpty(),
            gender = characterDto.gender.orEmpty(),
            origin = OriginMapeprNetwork(characterDto.origin).orig,
            location = LocationMapperNetwork(characterDto.location).loc,
            image = characterDto.image.orEmpty(),
            episode = characterDto.episode?.mapNotNull { it }.orEmpty(),
            url = characterDto.url.orEmpty(),
            created = characterDto.created.orEmpty()
        )
    }
}