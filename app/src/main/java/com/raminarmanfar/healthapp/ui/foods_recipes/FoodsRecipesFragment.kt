package com.raminarmanfar.healthapp.ui.foods_recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.raminarmanfar.healthapp.R

class FoodsRecipesFragment : Fragment() {

    private lateinit var slideshowViewModel: FoodsRecipesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        slideshowViewModel =
            ViewModelProviders.of(this).get(FoodsRecipesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_foods_recipes, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        slideshowViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}