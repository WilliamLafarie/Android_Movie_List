package com.example.partiel_mobile_api.network

/*

    [Class ApiConnect]

*/


class ApiConnect {

    companion object {

        var apiKey = "5a3aa2880d578a75afa150fb5e5b531605b3ae35"

        //Build the url with the API key for the request
        fun searchUrl(): String {
            return "https://comicvine.gamespot.com/api/movies/?api_key=$apiKey&format=json"
        }
    }
}