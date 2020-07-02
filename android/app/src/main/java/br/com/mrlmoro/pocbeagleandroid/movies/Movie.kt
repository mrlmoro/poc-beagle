package br.com.mrlmoro.pocbeagleandroid.movies

data class Movie(
    val id: String,
    val title: String,
    val synopsis : String,
    val genres: String,
    val durationMinutes: Int,
    val releaseDate: String,
    val imdbUrl: String,
    val bannerUrl: String,
    val likes: Int = 0
)