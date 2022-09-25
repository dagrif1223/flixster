package com.example.flixster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RatingBar
import android.widget.TextView

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var tvReleaseDate: TextView
    private lateinit var tvPopularity: TextView
    private lateinit var ratingBar: RatingBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        tvReleaseDate = findViewById(R.id.tvReleaseDate)
        tvPopularity = findViewById(R.id.tvPopularity)
        ratingBar = findViewById(R.id.rbVoteAverage)



        val movie = intent.getParcelableExtra<Movie>(MOVIE_EXTRA) as Movie
        Log.i(TAG, "Movie is $movie")
        tvReleaseDate.text = "Release Date: " + movie.releaseDate
        tvPopularity.text = "Popularity: " + movie.popularity.toString()
        ratingBar.rating = movie.voteAverage.toFloat()
    }
}