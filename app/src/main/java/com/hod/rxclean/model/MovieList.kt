package com.hod.rxclean.model

data class MovieList(
        val page: Int, val totalResults: Int, val totalPages: Int, val results: List<Movie>)

data class Movie(
        val id: Int, val title: String, val voteAverage: Double, val posterPath: String)

fun List<com.hod.domain.entity.Movie>?.toModel(): List<Movie> = TODO()

fun com.hod.domain.entity.Movie.toModel(): Movie = TODO()