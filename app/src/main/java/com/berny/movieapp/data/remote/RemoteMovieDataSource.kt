package com.berny.movieapp.data.remote

import com.berny.movieapp.application.AppConstants
import com.berny.movieapp.data.model.Movie
import com.berny.movieapp.data.model.MovieList
import com.berny.movieapp.repository.WebService

class RemoteMovieDataSource(private val webService: WebService) {

    suspend fun getUpcomingMovies (): MovieList = webService.getUpcomingMovies(AppConstants.API_KEY)

    suspend fun getTopRatedMovies (): MovieList = webService.getTopRatedMovies(AppConstants.API_KEY)

    suspend fun getPopularMovies (): MovieList = webService.getPopularMovies(AppConstants.API_KEY)
}