package com.example.flixster

import org.json.JSONArray


data class Movie(
    val movieId: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
        ){
    val posterImageUrl = "http://image.tmdb.org/t/p/w300$posterPath"

    companion object{
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for(i in 0 until movieJsonArray.length()){
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("title"),
                        movieJson.getString("overview"),
                        movieJson.getString("poster_path")

                    )
                )
            }
            return movies

        }
    }
}



