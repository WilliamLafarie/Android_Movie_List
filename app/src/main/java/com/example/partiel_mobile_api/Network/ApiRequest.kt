package com.example.partiel_mobile_api.Network

import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.example.partiel_mobile_api.MovieApp
import com.example.partiel_mobile_api.model.Movie
import org.json.JSONException
import org.json.JSONObject

class ApiRequest {
    companion object {
        fun requestMovie(success: (movies: MutableList<Movie>) -> Unit, error: (error: VolleyError?) ->Unit) {
            val apiUrl = ApiConnect.searchUrl()
            Log.wtf("URL", apiUrl)



            val arrayRequest = JsonObjectRequest(Request.Method.GET, apiUrl, null,
                Response.Listener<JSONObject>{ success ->
                    val listOfMovies = mutableListOf<Movie>()

                    try {
                        val dataMovie = success.getJSONArray("results")




                        for (i in 0 until dataMovie.length()) {
                            var movie = dataMovie.getJSONObject(i)
                            var title = movie.get("name").toString()
                            var poster_url = movie.getJSONObject("image").get("small_url").toString()
                            var overview = movie.get("description").toString()

                            listOfMovies.add(Movie(title,poster_url,overview))
                        }

                    } catch (e:JSONException) {
                        e.printStackTrace()

                    }

                    success(listOfMovies)
                },

                Response.ErrorListener { error ->
                    Log.wtf("ERROR", error.toString())
                }


            )
            MovieApp.requestQueue.add(arrayRequest)


        }

    }
}