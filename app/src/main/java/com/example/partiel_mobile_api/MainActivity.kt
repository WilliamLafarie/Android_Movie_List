package com.example.partiel_mobile_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.partiel_mobile_api.Network.ApiRequest
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var moviesAdapter: FastItemAdapter<MovieItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesAdapter = FastItemAdapter()
        // On lie le moviesAdapter à la RecyclerView
        // pour que la RecyclerView sache à qui demander les cellules
        RecyclerView.adapter = moviesAdapter

        // Préciser à la RecyclerView comment disposer les cellules
        // grâce à un LayoutManager

        // Ici on créé un LinearLayoutManager (vertical, par défaut)
        RecyclerView.layoutManager = LinearLayoutManager(this)


        // Ajout d'une ligne de séparation entre chaque cellule
        RecyclerView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))

        moviesAdapter.withOnClickListener { view, adapter, item, position ->
            val movie = item.movie
            val intent = MovieDetailActivity.createIntent(this, movie)

            //On démarre l'activité des détails de films
            startActivity(intent)

            true
        }



        // Ajout d'un listener pour récupérer la recherche tapée par l'utilisateur
        // dans le champ de recherche

        findMovies()

    }

    fun findMovies() {
        Log.wtf("FINDMOVIE", "OK")
        ApiRequest.requestMovie({resultMovies ->
            moviesAdapter.clear()
            Log.wtf("APIREQUEST", "OK")
            Log.wtf("APIREQUEST", resultMovies[0].title)


            for (movie in resultMovies) {
                moviesAdapter.add(MovieItem(movie))
            }
        }, {
        })
    }
}