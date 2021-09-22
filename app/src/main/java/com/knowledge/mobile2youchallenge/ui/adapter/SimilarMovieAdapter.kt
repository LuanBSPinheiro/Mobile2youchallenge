package com.knowledge.mobile2youchallenge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.knowledge.mobile2youchallenge.databinding.SimilarMovieBinding
import com.knowledge.mobile2youchallenge.ui.model.SimilarMovieItem
import com.squareup.picasso.Picasso

class SimilarMovieAdapter(private val movies: List<SimilarMovieItem>) :
    RecyclerView.Adapter<SimilarMovieAdapter.SimilarMovieHolder>() {

    class SimilarMovieHolder(val binding: SimilarMovieBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMovieHolder {
        val binding = SimilarMovieBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return SimilarMovieHolder(binding)
    }

    override fun onBindViewHolder(holder: SimilarMovieHolder, position: Int) {
        with(holder) {
            with(movies[position]) {
                binding.miniPosterTitle.text = title
                binding.miniPosterYear.text = releaseDate
                Picasso.get().load(posterPath).into(binding.miniPosterImage)
            }
        }
    }

    override fun getItemCount() = movies.size


}