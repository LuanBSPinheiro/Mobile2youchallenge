package com.knowledge.mobile2youchallenge.ui.model

import android.os.Bundle
import android.view.View
import com.knowledge.mobile2youchallenge.databinding.SimilarMovieBinding

data class SimilarMovie(
    val title: String,
    val poster: String,
    val year: String,
    val genres: List<String>
)

private var binding: SimilarMovieBinding? = null

var miniTitlePlaceHolder = "O Poderoso Chefinho"
var yearPlaceHolder = "2016"
var genres: List<String> = arrayListOf("Comedy", "Animation", "Kids")

fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    onViewCreated(view, savedInstanceState)
    binding?.miniPosterTitle!!.text = miniTitlePlaceHolder
    binding?.miniPosterGenres!!.text = genres.toString()
    binding?.miniPosterYear!!.text = yearPlaceHolder
}



