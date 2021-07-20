package com.example

import com.example.tvmaze.api.ApiInterface

class TvRepository(private val apiInterface: ApiInterface) {







suspend fun getShows(search:String) = apiInterface.searchShows(search)




}