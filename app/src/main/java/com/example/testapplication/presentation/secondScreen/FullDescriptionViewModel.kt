package com.example.testapplication.presentation.secondScreen

import androidx.lifecycle.ViewModel
import com.example.testapplication.data.local.model.ItemModel
import com.example.testapplication.domain.car.ItemUseCase

class FullDescriptionViewModel : ViewModel() {

    private val itemUseCase = ItemUseCase

    fun getItem(): ArrayList<ItemModel> {
        val items = itemUseCase.getItem()
        return items
    }
}