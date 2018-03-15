package com.hod.rxclean.model

data class MovieDetail(
        val id: Int,
        val title: String,
        val overview: String,
        val runtime: Int,
        val releaseDate: String,
        val tagline: String,
        val posterPath: String,
        val backdropPath: String,
        val budget: Int,
        val revenue: Int,
        val voteAverage: Float,
        val voteCount: Int,
        val popularity: Float,
        val genres: List<Genre>,
        val imdbId: String)

data class Genre(val id: Int, val name: String)
