package com.example.divtest.data.networkDto

import com.google.gson.annotations.SerializedName

data class InfoDtoNetwork(

    @SerializedName("count") val count: Int?,
    @SerializedName("next") val next: String?,
    @SerializedName("pages") val pages: Int?,
    @SerializedName("prev") val prev: String?,

    )