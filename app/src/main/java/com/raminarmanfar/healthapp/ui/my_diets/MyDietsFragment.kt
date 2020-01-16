package com.raminarmanfar.healthapp.ui.my_diets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.raminarmanfar.healthapp.R

class MyDietsFragment : Fragment() {

    private lateinit var myDietsViewModel: MyDietsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myDietsViewModel =
            ViewModelProviders.of(this).get(MyDietsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_my_diets, container, false)
        val textView: TextView = root.findViewById(R.id.text_my_diets)
        myDietsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}