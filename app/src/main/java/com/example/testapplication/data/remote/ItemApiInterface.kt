package com.example.testapplication.data.remote

import com.example.testapplication.data.remote.model.CarApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ItemApiInterface {
    @Headers("Content-Type: application/json")
    @GET("/products")
    fun getItems(): retrofit2.Call<CarApiModel>
    fun getResponseItem(): Response<CarApiModel>

}