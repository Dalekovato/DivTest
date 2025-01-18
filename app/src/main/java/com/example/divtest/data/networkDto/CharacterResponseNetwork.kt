package com.example.divtest.data.networkDto

import com.google.gson.annotations.SerializedName

data class CharacterResponseNetwork(

    @SerializedName("info") val info: InfoDtoNetwork?,
    @SerializedName("results") val results: List<CharacterDtoNetwork?>?,

    )