package com.example.partiel_mobile_api

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.bumptech.glide.Glide
import com.example.partiel_mobile_api.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.cell_movie.view.*

/*

    [Class MovieDetailsActivity]

*/

class MovieDetailActivity : AppCompatActivity() {

    companion object {

        private val EXTRA_MOVIE = "extra_movie"

        fun createIntent(context: Context, movie: Movie): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE, movie)

            return intent
        }
    }

    private var mywebview: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        mywebview = findViewById<WebView>(R.id.cell_detail_overview)


        this.title = movie.title

        Glide
            .with(cell_detail_picture)
            .load(movie.posterUrl)
            .into(cell_detail_picture)

        mywebview!!.loadData(movie.overview, "text/html", "utf-8")
    }
}

