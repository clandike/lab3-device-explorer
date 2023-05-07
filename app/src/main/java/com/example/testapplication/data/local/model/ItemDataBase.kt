package com.example.testapplication.data.local.model

class ItemDataBase {

    var item: ItemModel? = null

    fun createItem(images: ArrayList<String>?, description: String?, brand: String?) {
        item = ItemModel(images,description,brand)
    }
}