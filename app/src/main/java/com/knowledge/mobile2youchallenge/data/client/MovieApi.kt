package com.knowledge.mobile2youchallenge.data.client

import com.knowledge.mobile2youchallenge.ui.model.Movie
import com.knowledge.mobile2youchallenge.ui.model.SimilarMovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val ApiKey = "9fe1de6b4d8fb8cbb61720206cc18686"

interface MovieApi {

    @GET("103")
    fun getMovieInfo(
        @Query("api_key") apiKey : String = ApiKey
    ): Call<Movie>

    @GET(value = "103/similar")
    fun getSimilarMovie(
        @Query("api_key") apiKey : String = ApiKey
    ): Call<SimilarMovieList>
}
