package com.knowledge.mobile2youchallenge.ui.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("vote_count")
    val likes: String,
    @SerializedName("popularity")
    val popularity: String
)




