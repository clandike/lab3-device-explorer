package com.example.testapplication.domain.car

import com.example.testapplication.data.ItemRepository
import com.example.testapplication.data.remote.model.ItemApiModel
import retrofit2.Call

// мізки, перетворення якість
object ItemsUseCase {
    private val repo = ItemRepository

    fun getCar(): Call<ItemApiModel> {
        return repo.getItems()
    }

}