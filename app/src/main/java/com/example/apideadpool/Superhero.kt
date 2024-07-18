package com.example.apideadpool

import com.google.gson.annotations.SerializedName

data class Superhero(
    val id: String,
    val name: String,
    val powerstats: Powerstats,
    val biography: Biography,
    val image: Image
)

data class Powerstats(
    val intelligence: String,
    val strength: String,
    val speed: String
)

data class Biography(
    @SerializedName("full-name")
    val fullName: String
)

data class Image(
    val url: String
)