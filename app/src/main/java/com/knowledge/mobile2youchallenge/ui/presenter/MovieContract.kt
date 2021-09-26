package com.knowledge.mobile2youchallenge.ui.presenter

import com.knowledge.mobile2youchallenge.ui.model.Movie
import com.knowledge.mobile2youchallenge.ui.model.SimilarMovieItem

interface MovieContract {

    interface View {
        fun showLoadingDialog()
        fun hideLoadingDialog()
        fun showError(message: String)
        fun movieInfo(movie: Movie)
        fun movieList(listMovie: List<SimilarMovieItem>)
        fun favoriteButton()

    }

    interface Presenter {
        fun loadMovies()
        fun loadListMovieSimilar()
        fun setView(view: MovieContract.View?)
    }
}