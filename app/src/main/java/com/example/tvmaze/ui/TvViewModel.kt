package com.example.tvmaze.ui

import androidx.lifecycle.ViewModel
import com.example.TvRepository
import com.example.tvmaze.api.ApiInterface
import com.example.tvmaze.di.viewModels
import kotlinx.coroutines.Job

class TvViewModel(private val tvRepository: TvRepository) : ViewModel() {


  





suspend fun getShows(search:String) =
    tvRepository.getShows(search)









}