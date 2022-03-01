package com.example.giphiapp

import com.example.giphiapp.model.GiphiModel
import com.example.giphiapp.model.model1.SearchGiphi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RefrofitClientSearch {

    @GET("v1/gifs/search")
    fun getAllMovieList123(@Query("apikey") apikey: String, @Query("q") q: String): Call<SearchGiphi>
}
//@Query("q") q: String