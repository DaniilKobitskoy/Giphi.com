package com.example.giphiapp.common

import com.example.giphiapp.RetrofitClientGiphi
import com.example.giphiapp.clientServices.RetrofitClient

object Common {

    private var BASE_URL = "https://api.giphy.com/"

    val retrofitService: RetrofitClientGiphi
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitClientGiphi::class.java)
}