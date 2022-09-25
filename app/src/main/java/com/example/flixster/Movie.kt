package com.example.flixster

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import org.json.JSONArray

@Parcelize
data class Movie(
    val movieId: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
    val releaseDate: String,
    val popularity: Double
        ) : Parcelable {
    @IgnoredOnParcel
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
                        movieJson.getString("poster_path"),
                        movieJson.getDouble("vote_average"),
                        movieJson.getString("release_date"),
                        movieJson.getDouble("popularity")

                    )
                )
            }
            return movies

        }
    }
}



