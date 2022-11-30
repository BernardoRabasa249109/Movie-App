package com.berny.movieapp.ui.movie.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.berny.movieapp.core.BaseViewHolder
import com.berny.movieapp.data.model.Movie
import com.berny.movieapp.databinding.MovieItemBinding
import com.bumptech.glide.Glide

class MovieAdapter (private val moviesList: List<Movie>, private val itemClickListener: OnMovieClickListener
):  RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMovieClickListener {
        fun omMovieClick(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MoviesViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener
            itemClickListener.omMovieClick(moviesList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MoviesViewHolder -> holder.bind(moviesList[position])
        }
    }

    override fun getItemCount(): Int = moviesList.size


    private inner class MoviesViewHolder(val binding: MovieItemBinding,
    val context: Context): BaseViewHolder<Movie>(binding.root){
        override fun bind(item: Movie) {
            Glide.with(context).load("https://image.tmdb.org/t/p/w500/${item.poster_path}")
                .centerCrop().into(binding.imgMovie)

        }
    }

}