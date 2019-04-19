package com.example.partiel_mobile_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.partiel_mobile_api.network.ApiRequest
import com.example.partiel_mobile_api.item.MovieItem
import com.example.partiel_mobile_api.model.Movie
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

/*

    [Class MainActivity]

*/

class MainActivity : AppCompatActivity() {

    private lateinit var moviesAdapter: FastItemAdapter<MovieItem>

    private val listMovies = mutableListOf<Movie>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesAdapter = FastItemAdapter()

        RecyclerView.adapter = moviesAdapter


        RecyclerView.layoutManager = LinearLayoutManager(this)


        RecyclerView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))

        moviesAdapter.withOnClickListener { view, adapter, item, position ->

            val movie = item.movie
            val intent = MovieDetailActivity.createIntent(this, movie)


            startActivity(intent)

            true
        }

        /*
        searchEditText.addTextChangedListener { editable ->
            val query = editable.toString()

            findMovies()


            // On filtre sur les films existants

            // boucle sur tous les titres de films
            // condition si match query <-> titre
            // on enleve tous les autres

            // Filter prend en paramètre un lambda ( fonction avec en paramètre yb Movie et le retour
            // attendu est un booléen: true on conserve l'objet Movie suite au filtre
            // false on le conserve pas
            val filteredMovies = listMovies.filter {

                // Ici on retourne le test (Est-ce que le titre du film contient la recherche
                it.title.toLowerCase().contains(query.toLowerCase())
            }

            // On va effacer la liste (RecyclerView)
            moviesAdapter.clear()

            // On affiche les nouveaux résultats (rafraichissement)
            for(movie in filteredMovies) {
                moviesAdapter.add(MovieItem(movie))
            }

        }

        */

        findMovies()


    }

    private fun findMovies() {

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