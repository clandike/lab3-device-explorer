package com.example.testapplication.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceBuilder {

    const val BASE_URL = "https://dummyjson.com"

    val itemApi: ItemApiInterface = createRetrofit().create(ItemApiInterface::class.java)

    private fun createRetrofit(): Retrofit {

        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}