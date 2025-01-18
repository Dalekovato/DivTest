package com.example.divtest.domain.mapper

import com.example.divtest.data.networkDto.LocationDtoNetwork
import com.example.divtest.domain.model.LocationDomain

class LocationMapperNetwork(locationDto: LocationDtoNetwork?) {

    val loc by lazy {
        LocationDomain(
            name = locationDto?.name.orEmpty(),
            url = locationDto?.url.orEmpty()
        )
    }
}