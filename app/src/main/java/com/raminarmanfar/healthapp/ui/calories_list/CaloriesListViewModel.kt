package com.raminarmanfar.healthapp.ui.calories_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CaloriesListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Calories List Fragment"
    }
    val text: LiveData<String> = _text
}