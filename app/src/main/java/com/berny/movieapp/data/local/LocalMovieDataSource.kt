package com.berny.movieapp.data.local

import com.berny.movieapp.data.model.Movie
import com.berny.movieapp.data.model.MovieEntity
import com.berny.movieapp.data.model.MovieList
import com.berny.movieapp.data.model.toMovieList

class LocalMovieDataSource(private val movieDao: MovieDao) {

    suspend fun getUpcomingMovies (): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "upcoming" }.toMovieList()

    }

    suspend fun getTopRatedMovies (): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "toprated" }.toMovieList()

    }

    suspend fun getPopularMovies (): MovieList {
        return movieDao.getAllMovies().filter { it.movie_type == "popular" }.toMovieList()

    }

    suspend fun saveMovie(movie: MovieEntity){
        movieDao.saveMovie(movie)
    }
}