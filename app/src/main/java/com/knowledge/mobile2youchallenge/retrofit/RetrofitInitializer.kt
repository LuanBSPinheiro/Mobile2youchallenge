package com.knowledge.mobile2youchallenge.retrofit

import com.knowledge.mobile2youchallenge.data.client.MovieApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInitializer {

    private const val TMDB_URL = "https://api.themoviedb.org/3/movie/"

    private val okHttpClient = OkHttpClient.Builder()
        .build()

    val instance: MovieApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(TMDB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(MovieApi::class.java)
    }
}