package com.example.partiel_mobile_api.Network

import com.example.partiel_mobile_api.model.Movie

class ApiResult {
    companion object {
        var page = 1

        var totalResults = 0

        var totalPages = 0

        lateinit var results : Array<Movie>
    }

}