package com.example.divtest.data.mapper

import com.example.divtest.data.networkDto.InfoDtoNetwork
import com.example.divtest.data.model.InfoDomain

class InfoMapperNetwork(infoDto: InfoDtoNetwork?) {

    val info by lazy {

        InfoDomain(
            count = infoDto?.count ?: 0,
            next = infoDto?.next.orEmpty(),
            pages = infoDto?.pages ?: 0,
            prev = infoDto?.prev.orEmpty()
        )
    }
}