package com.example.tvmaze.api

import TvMazeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("search/shows")
    suspend fun searchShows( @Query("q") query: String): Call<TvMazeResponse>

}