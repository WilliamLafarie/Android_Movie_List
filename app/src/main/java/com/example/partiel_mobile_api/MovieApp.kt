package com.example.partiel_mobile_api

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class MovieApp: Application() {
    companion object {
        lateinit var requestQueue: RequestQueue
    }

    // Appellée une seule fois au lancement de l'app
    override fun onCreate() {
        super.onCreate()

        // Initialisation de la requestQueue
        requestQueue = Volley.newRequestQueue(this)
    }
}