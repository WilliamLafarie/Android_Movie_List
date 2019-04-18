package com.example.partiel_mobile_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.partiel_mobile_api.Network.ApiRequest
import com.example.partiel_mobile_api.Network.ApiRequest.Companion.requestMovie
import com.example.partiel_mobile_api.model.Movie
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var moviesAdapter: FastItemAdapter<MovieItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // On va créer un adaptateur dont le rôle sera de fournir
        // des cellules à la RecyclerView

        moviesAdapter = FastItemAdapter<MovieItem>()

        // On lie le moviesAdapter à la RecyclerView
        // pour que la RecyclerView sache à qui demander les cellules
        RecyclerView.adapter = moviesAdapter

        // Préciser à la RecyclerView comment disposer les cellules
        // grâce à un LayoutManager

        // Ici on créé un LinearLayoutManager (vertical, par défaut)
        RecyclerView.layoutManager = LinearLayoutManager(this)

        // Exemple pour afficher une liste à l'horizontal

        /*RecyclerView.layoutManager = LinearLayoutManager(this,
            RecyclerView.HORIZONTAL, false)*/


        // Ajout d'une ligne de séparation entre chaque cellule
        //RecyclerView.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        // Bonus pour afficher les cellules sous forme de grille (ici à 2 colonnes)
        //moviesRecyclerView.layoutManager = GridLayoutManager(this, 2)


        // Ajout d'un listener pour récupérer la recherche tapée par l'utilisateur
        // dans le champ de recherche

        findMovie("Dare")


    }

    fun findMovie(query: String) {
        requestMovie(query)
    }
}