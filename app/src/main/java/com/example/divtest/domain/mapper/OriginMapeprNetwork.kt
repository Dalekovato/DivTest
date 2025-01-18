package com.example.divtest.domain.mapper

import com.example.divtest.data.networkDto.OriginDtoNetwork
import com.example.divtest.domain.model.OriginDomain

class OriginMapeprNetwork(originDto: OriginDtoNetwork?) {

    val orig by lazy {
        OriginDomain(
            name = originDto?.name.orEmpty(),
            url = originDto?.url.orEmpty()
        )
    }
}