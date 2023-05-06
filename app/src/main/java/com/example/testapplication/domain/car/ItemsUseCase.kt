package com.example.testapplication.domain.car

import com.example.testapplication.data.ItemRepository
import com.example.testapplication.data.remote.model.Products

// мізки, перетворення якість
object ItemsUseCase {
    private val repo = ItemRepository

    fun getCar(): ArrayList<Products>? {
        return repo.getItems()
    }

}