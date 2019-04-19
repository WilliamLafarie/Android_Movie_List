package com.example.partiel_mobile_api

import android.app.Application
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/*

    [Class MovieApp]

*/

class MovieApp: Application() {
    companion object {
        lateinit var requestQueue: RequestQueue
    }

    // Call when the app is launched
    override fun onCreate() {
        super.onCreate()

        // Init of the requestQueue
        requestQueue = Volley.newRequestQueue(this)
    }
}