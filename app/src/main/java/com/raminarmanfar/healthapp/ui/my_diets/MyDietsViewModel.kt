package com.raminarmanfar.healthapp.ui.my_diets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyDietsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is My diets Fragment"
    }
    val text: LiveData<String> = _text
}