package com.knowledge.mobile2youchallenge.ui.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.knowledge.mobile2youchallenge.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

data class Movie(
    val poster: String,
    val title: String,
    val likes: String,
    val views: String,
    val likedIt: Boolean,
)

private var binding: ActivityMainBinding? = null
val posterPlaceHolder: String =
    "http://www.loucademiadecinema.com.br/wp-content/uploads/2018/01/O-Poderoso-Chefão-1972-The-Godfather-original.jpg"
val titlePlaceHolder: String = "O Poderoso Chefão"
val popularity: String = "56.433"
val likes: String = "14809"

fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
): View? {
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    binding = ActivityMainBinding.inflate(inflater, container, false)
    return binding?.root

}

fun populate() {
    binding?.movieTitle!!.text = titlePlaceHolder
    binding?.movieLikes!!.text = likes
    binding?.viewsTotal!!.text = popularity
    Picasso.get().load(posterPlaceHolder).into(binding?.imageMovie!!)
}




