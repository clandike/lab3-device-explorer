package com.example.testapplication.presentation.second

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplication.data.local.model.ItemModel
import com.example.testapplication.domain.car.ItemUseCase

class FullDescriptionViewModel : ViewModel() {

    private val itemUseCase = ItemUseCase
    val itemCollection = MutableLiveData<ArrayList<ItemModel>>()

    fun getItem(): ArrayList<ItemModel> {
        val items = itemUseCase.getItem()
        return items
    }
}