package com.example.divtest.data.networkDto

import com.google.gson.annotations.SerializedName

enum class StatusImgNetwork (val value: String) {

    @SerializedName("Alive") ALIVE ("Alive"),
    @SerializedName("Dead") DEAD ("Dead"),
    UNKNOWN ("Unknown")

}