package com.example.testapplication.presentation.first

import androidx.lifecycle.ViewModel
import com.example.testapplication.data.remote.model.Products
import com.example.testapplication.domain.car.ItemsUseCase

class MainListViewModel: ViewModel() {

    private val carUseCase = ItemsUseCase

    fun getData() : ArrayList<Products>? {
            return carUseCase.getCar()
    }
}