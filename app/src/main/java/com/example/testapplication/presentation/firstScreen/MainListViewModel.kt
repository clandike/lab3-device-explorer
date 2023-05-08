package com.example.testapplication.presentation.firstScreen

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapplication.data.remote.model.ItemApiModel
import com.example.testapplication.domain.car.ItemUseCase
import kotlinx.coroutines.launch

class MainListViewModel : ViewModel() {

    private val itemUseCase = ItemUseCase
    val items = MutableLiveData<ItemApiModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun putItem(images: ArrayList<String>?, description: String?, brand: String?) {
        itemUseCase.createItem(images, description, brand)
    }

    @SuppressLint("SuspiciousIndentation")
    fun getData() {
        viewModelScope.launch {
            try {
                val getItems = itemUseCase.getItems()
                isLoading.postValue(true)
                items.postValue(getItems!! as ItemApiModel?)
                isLoading.postValue(false)
            } catch (ex: Exception){
                items.postValue(ItemApiModel())
                // to avoid throwing exception when no internet connection
            }

        }
    }
}
