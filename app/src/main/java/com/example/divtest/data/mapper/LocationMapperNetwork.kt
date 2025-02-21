package com.example.divtest.data.mapper

import com.example.divtest.data.networkDto.LocationDtoNetwork
import com.example.divtest.data.model.LocationDomain

class LocationMapperNetwork(locationDto: LocationDtoNetwork?) {

    val loc by lazy {
        LocationDomain(
            name = locationDto?.name.orEmpty(),
            url = locationDto?.url.orEmpty()
        )
    }
}