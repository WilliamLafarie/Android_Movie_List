package com.example.partiel_mobile_api

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.partiel_mobile_api.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.cell_movie.view.*

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        // Création d'une méthode statique pour générer et remplir un nouvel Intent

        private val EXTRA_MOVIE = "extra_movie"

        fun createIntent(context: Context, movie: Movie): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(EXTRA_MOVIE, movie)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)

        // On affiche le titre du film dans l'App Bar
        this.title = movie.title

        Glide
            .with(cell_detail_picture)
            .load(movie.posterUrl)
            .into(cell_detail_picture)

        cell_detail_overview.text = movie.overview
    }
}

