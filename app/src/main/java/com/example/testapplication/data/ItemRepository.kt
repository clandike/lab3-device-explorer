package com.example.testapplication.data

import com.example.testapplication.data.remote.ApiServiceBuilder
import com.example.testapplication.data.remote.model.ItemApiModel

// клас, який відповідає звідкіля нам брати дані: локальні(local) або ввідалені(remote)
object ItemRepository {

    private val api = ApiServiceBuilder.itemApi

    suspend fun getItems(): ItemApiModel? {
        val response = api.getItems()
        if (response.isSuccessful && response.body() != null) {
            val body = response.body()
            return body
        } else {
            return null
        }
    }
}