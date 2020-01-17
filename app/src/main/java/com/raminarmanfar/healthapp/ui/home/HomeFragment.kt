package com.raminarmanfar.healthapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.raminarmanfar.healthapp.R

class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnCaloriesList).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnFoodsRecipes).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnMyDiets).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnSettings).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnAbout).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnCaloriesList -> navController!!.navigate(R.id.action_nav_home_to_nav_calories_list)
            R.id.btnFoodsRecipes -> navController!!.navigate(R.id.action_nav_home_to_nav_foods_recipes)
            R.id.btnMyDiets -> navController!!.navigate(R.id.action_nav_home_to_nav_my_diets)
            R.id.btnSettings -> navController!!.navigate(R.id.action_nav_home_to_nav_settings)
            R.id.btnAbout -> navController!!.navigate(R.id.action_nav_home_to_nav_about)
        }
    }
}