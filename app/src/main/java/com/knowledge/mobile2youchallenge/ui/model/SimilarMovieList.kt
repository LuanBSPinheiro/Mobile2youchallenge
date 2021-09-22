package com.knowledge.mobile2youchallenge.ui.model

import com.google.gson.annotations.SerializedName

data class SimilarMovieList(
    val results: List<SimilarMovieItem>
)

data class SimilarMovieItem(
    @SerializedName("title")
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String
)



