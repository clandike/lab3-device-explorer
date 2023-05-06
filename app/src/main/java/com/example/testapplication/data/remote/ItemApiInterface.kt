package com.example.testapplication.data.remote

import com.example.testapplication.data.remote.model.ItemApiModel
import retrofit2.http.GET
import retrofit2.http.Headers

interface ItemApiInterface {
    @Headers("Content-Type: application/json")
    @GET("/products")
    fun getItems(): retrofit2.Call<ItemApiModel>

}