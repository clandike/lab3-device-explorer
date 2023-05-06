package com.example.testapplication.data

import com.example.testapplication.data.remote.ApiFactory
import com.example.testapplication.data.remote.model.CarApiModel
import com.example.testapplication.data.remote.model.Products

// клас, який відповідає звідкіля нам брати дані: локальні(local) або ввідалені(remote)
object ItemRepository {

    private val api = ApiFactory.carApi

    fun getItems(): ArrayList<Products>? {
        val response = api.getResponseItem()
        if (response.isSuccessful && response.body() != null) {
            return response.body()!!.products
        } else {
            return null
        }
    }
}