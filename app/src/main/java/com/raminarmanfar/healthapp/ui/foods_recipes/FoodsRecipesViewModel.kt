package com.raminarmanfar.healthapp.ui.foods_recipes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FoodsRecipesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Foods Recipes Fragment"
    }
    val text: LiveData<String> = _text
}