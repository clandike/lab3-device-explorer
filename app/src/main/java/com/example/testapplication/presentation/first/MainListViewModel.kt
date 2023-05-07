package com.example.testapplication.presentation.first

import androidx.lifecycle.ViewModel
import com.example.testapplication.data.remote.model.ItemApiModel
import com.example.testapplication.domain.car.ItemUseCase
import retrofit2.Call

class MainListViewModel : ViewModel() {

    private val itemUseCase = ItemUseCase

    fun putItem(images: ArrayList<String>?, description: String?, brand: String?) {
        itemUseCase.createItem(images,description,brand)
    }



    fun getData(): Call<ItemApiModel> {
        return itemUseCase.getItems()
    }
}