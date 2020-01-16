package com.raminarmanfar.healthapp.ui.calories_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.raminarmanfar.healthapp.R

class CaloriesListFragment : Fragment() {

    private lateinit var caloriesListViewModel: CaloriesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        caloriesListViewModel =
            ViewModelProviders.of(this).get(CaloriesListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_calories_list, container, false)
        val textView: TextView = root.findViewById(R.id.text_calories_list)
        caloriesListViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}