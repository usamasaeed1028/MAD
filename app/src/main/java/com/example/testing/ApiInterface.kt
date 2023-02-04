package com.example.testing

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET( value = "posts")
    fun getData(): Call<List<MyDataItem>>
}