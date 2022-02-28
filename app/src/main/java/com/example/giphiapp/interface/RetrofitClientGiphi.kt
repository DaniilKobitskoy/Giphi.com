package com.example.giphiapp

import com.example.giphiapp.model.GiphiModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitClientGiphi {

    @GET("v1/gifs/trending?api_key=G15JgFWc0zCOV4JfylKfBT0T9DuOQzFJ")
    fun getAllMovieList(): Call<GiphiModel>
}