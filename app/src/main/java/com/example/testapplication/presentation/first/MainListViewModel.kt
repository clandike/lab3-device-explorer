package com.example.testapplication.presentation.first

import androidx.lifecycle.ViewModel
import com.example.testapplication.data.remote.model.ItemApiModel
import com.example.testapplication.domain.car.ItemsUseCase
import retrofit2.Call

class MainListViewModel: ViewModel() {

    private val carUseCase = ItemsUseCase

    fun getData(): Call<ItemApiModel> {
        return carUseCase.getCar()
    }
}