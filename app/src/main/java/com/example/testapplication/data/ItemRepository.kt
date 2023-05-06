package com.example.testapplication.data

import com.example.testapplication.data.remote.ApiServiceBuilder
import com.example.testapplication.data.remote.ItemApiInterface
import com.example.testapplication.data.remote.model.ItemApiModel
import retrofit2.Call

// клас, який відповідає звідкіля нам брати дані: локальні(local) або ввідалені(remote)
object ItemRepository {

    private val api = ApiServiceBuilder.buildService(ItemApiInterface::class.java)

    fun getItems(): Call<ItemApiModel> {
        return api.getItems()
    }
}