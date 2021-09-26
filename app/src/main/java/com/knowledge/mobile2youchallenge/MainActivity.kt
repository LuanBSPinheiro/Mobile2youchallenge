package com.knowledge.mobile2youchallenge

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.knowledge.mobile2youchallenge.databinding.ActivityMainBinding
import com.knowledge.mobile2youchallenge.ui.adapter.SimilarMovieAdapter
import com.knowledge.mobile2youchallenge.ui.model.Movie
import com.knowledge.mobile2youchallenge.ui.model.SimilarMovieItem
import com.knowledge.mobile2youchallenge.ui.presenter.MovieContract
import com.knowledge.mobile2youchallenge.ui.presenter.MoviePresenter
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), MovieContract.View {

    private lateinit var binding: ActivityMainBinding
    private var presenter : MovieContract.Presenter? = MoviePresenter()
    private var isPressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter?.setView(this)
        presenter?.loadMovies()
        presenter?.loadListMovieSimilar()

        favoriteButton()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.setView(null)
        presenter = null
    }

    override fun showLoadingDialog() {
        binding.loading.visibility = View.VISIBLE
    }

    override fun hideLoadingDialog() {
        binding.loading.visibility = View.GONE
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun movieInfo(movie: Movie) {
        Picasso.get().load(movie.backdropPath).into(binding.imageMovie)
        binding.movieTitle.text = movie.title
        binding.movieLikes.text = movie.likes
        binding.viewsTotal.text = movie.popularity
    }

    override fun movieList(listMovie: List<SimilarMovieItem>) {
        binding.similarMoviesRV.adapter.apply {
            val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            binding.similarMoviesRV.layoutManager = layoutManager
            binding.similarMoviesRV.adapter =
                SimilarMovieAdapter(listMovie)
        }
    }

    override fun favoriteButton() {
        binding.favButton.setOnClickListener {
            if (isPressed) {
                binding.favButton.setImageResource(R.drawable.ic_to_favorite)
                Toast.makeText(this, getString(R.string.desfav), Toast.LENGTH_SHORT).show()
            } else {
                binding.favButton.setImageResource(R.drawable.ic_favorited)
                Toast.makeText(this, getString(R.string.fav), Toast.LENGTH_SHORT).show()
            }
            isPressed = !isPressed
        }
    }
}