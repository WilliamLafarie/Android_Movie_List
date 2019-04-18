package com.example.partiel_mobile_api.Network

import android.os.Build.VERSION_CODES.O
import android.util.Log
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.example.partiel_mobile_api.model.Movie
import com.example.partiel_mobile_api.MovieApp
import org.json.JSONArray
import org.json.JSONObject

class ApiRequest {
    companion object {
        fun requestMovie(query: String) {

            val apiUrl = ApiConnect.searchUrl(query)
            Log.wtf("URL", apiUrl)

            val stringRequest = StringRequest(Request.Method.GET, apiUrl,
                Listener<String> { success ->

                    var resultString = success.toString()
                    var resultObject = JSONObject(resultString)
                    val movie = resultObject.getJSONArray("results")

                    var title: String = ""
                    var image: String = ""

                    for (i in 0 until movie.length()) {
                        var movieObject: JSONObject = movie.getJSONObject(i)
                        title += movieObject.get("name")
                        image += movieObject.getJSONObject("image").get("medium_url")

                        Movie(title, image)
                    }



                    Log.wtf("Title", title)
                    Log.wtf("Img", image)








                },
                Response.ErrorListener { failure ->
                    Log.wtf("ERROR", failure.toString())
                    Log.wtf("ERRORDEMERDE", "MARCHE PAS MDRERE")
                }
            )
            MovieApp.requestQueue.add(stringRequest)
        }

    }
}