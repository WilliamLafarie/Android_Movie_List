package com.example.partiel_mobile_api.Network

class ApiConnect {

    companion object {
        var apiKey = "5a3aa2880d578a75afa150fb5e5b531605b3ae35"

        //Fonction pour appeler l'API
        fun searchUrl(query: String): String {
            return "https://comicvine.gamespot.com/api/movies/?api_key=$apiKey&format=json&filter=name:$query"
        }
    }
}