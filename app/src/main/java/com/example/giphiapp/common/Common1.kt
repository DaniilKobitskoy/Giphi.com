package com.example.giphiapp.common

import com.example.giphiapp.RefrofitClientSearch
import com.example.giphiapp.RetrofitClientGiphi
import com.example.giphiapp.clientServices.RetrofitClient

object Common1 {

    private var BASE_URL = "https://api.giphy.com/"

    val retrofitService: RefrofitClientSearch
        get() = RetrofitClient.getClient(BASE_URL).create(RefrofitClientSearch::class.java)
}