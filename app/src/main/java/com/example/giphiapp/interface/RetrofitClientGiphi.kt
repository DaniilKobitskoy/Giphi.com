package com.example.giphiapp

import com.example.giphiapp.model.GiphiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitClientGiphi {

    @GET("v1/gifs/trending")
    fun getAllMovieList(@Query("api_key") apikey: Any): Call<GiphiModel>
}