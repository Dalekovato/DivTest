package com.example.divtest.domain.model

import com.example.divtest.data.networkDto.StatusImgNetwork

class CharactersDomain(
    val id: Int,
    val name: String,
    val status: StatusImgNetwork,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginDomain,
    val location: LocationDomain,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
    )