package com.example.testapplication.domain.car

import com.example.testapplication.data.ItemRepository
import com.example.testapplication.data.local.model.ItemDataBase
import com.example.testapplication.data.local.model.ItemModel
import com.example.testapplication.data.remote.model.ItemApiModel

// мізки, перетворення якість
object ItemUseCase {
    private val repo = ItemRepository
    private val itemData = ItemDataBase()

    fun createItem(images: ArrayList<String>?, description: String?, brand: String?) {
        itemData.createItem(images, description, brand)
    }

    fun getItem(): ArrayList<ItemModel> {
        val listItems = ArrayList<ItemModel>()
        listItems.add(itemData.item!!)
        return listItems
    }

    suspend fun getItems(): ItemApiModel? {
        if (repo.getItems() == null) {
            return null
        } else {
            return repo.getItems()
        }
    }
}