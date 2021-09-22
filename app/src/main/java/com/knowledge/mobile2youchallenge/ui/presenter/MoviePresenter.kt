package com.knowledge.mobile2youchallenge.ui.presenter

import com.knowledge.mobile2youchallenge.retrofit.RetrofitInitializer
import com.knowledge.mobile2youchallenge.ui.model.Movie
import com.knowledge.mobile2youchallenge.ui.model.SimilarMovieList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val URL_IMAGE = "https://image.tmdb.org/t/p/original/"
private const val URL_IMAGE_W500 = "https://image.tmdb.org/t/p/w500/"

class MoviePresenter(private val contractView: MovieContract.View) : MovieContract.Presenter {

    override fun loadMovies() {
        contractView.showLoadingDialog()
        RetrofitInitializer.instance.getMovieInfo()
            .enqueue(object : Callback<Movie> {
                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            val newMovie = it.copy(
                                backdropPath = URL_IMAGE + it.backdropPath,
                                likes = it.likes + " likes",
                                popularity = it.popularity + " pessoas"
                            )
                            contractView.movieInfo(newMovie)
                            contractView.hideLoadingDialog()
                        }
                    }
                }

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    contractView.showError(t.message ?: "")
                    contractView.hideLoadingDialog()
                }
            })
    }

    override fun loadListMovieSimilar() {
        RetrofitInitializer.instance.getSimilarMovie()
            .enqueue(object : Callback<SimilarMovieList> {
                override fun onResponse(
                    call: Call<SimilarMovieList>,
                    response: Response<SimilarMovieList>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            val newMovieList = it.results.map { movieItem ->
                                movieItem.copy(
                                    posterPath = URL_IMAGE_W500 + movieItem.posterPath
                                )
                            }
                            contractView.movieList(newMovieList)
                        }
                    }
                }

                override fun onFailure(call: Call<SimilarMovieList>, t: Throwable) {
                    contractView.showError(t.message ?: "")
                }
            })
    }
}