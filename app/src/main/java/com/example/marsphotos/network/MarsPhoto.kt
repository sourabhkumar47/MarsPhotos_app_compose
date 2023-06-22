package com.example.marsphotos.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto(
    val id: String,

    //To use variable names in your data class that
    // differ from the key names in the JSON response,
    // use the @SerialName annotation
    @SerialName(value = "img_src")
    val imgSrc: String,
)
