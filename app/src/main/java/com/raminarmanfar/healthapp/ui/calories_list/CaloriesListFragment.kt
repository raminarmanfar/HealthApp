package com.raminarmanfar.healthapp.ui.calories_list

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raminarmanfar.healthapp.CaloriesCategoriesAdapter
import com.raminarmanfar.healthapp.HealthDBContract
import com.raminarmanfar.healthapp.HealthDBHelper
import com.raminarmanfar.healthapp.R

class CaloriesListFragment : Fragment() {

    private lateinit var caloriesListViewModel: CaloriesListViewModel
    private lateinit var hDatabase: SQLiteDatabase
    private lateinit var hAdapter: CaloriesCategoriesAdapter
    private lateinit var txtName: EditText
    private lateinit var txtType: EditText

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dbHelper: HealthDBHelper = HealthDBHelper(context)
        hDatabase = dbHelper.writableDatabase
        val recyclerView: RecyclerView = view.findViewById(R.id.rvCaloriesCategories)
        recyclerView.layoutManager = LinearLayoutManager(context)
        hAdapter = CaloriesCategoriesAdapter(context, getAllCategories())
        recyclerView.adapter = hAdapter

        txtName = view.findViewById<EditText>(R.id.txtName)
        txtType = view.findViewById<EditText>(R.id.txtType)
        val btnSave = view.findViewById<Button>(R.id.btnSaveCategory)

        btnSave.setOnClickListener {
            if (txtName.text.toString().trim().length == 0 || txtType.text.trim().toString().length == 0) {
                Toast.makeText(context, "Name or type is not set.", Toast.LENGTH_LONG).show()
            }
            else {
                val name: String = txtName.text.toString()
                val type: String = txtType.text.toString()
                val cv: ContentValues = ContentValues()
                cv.put(HealthDBContract.CaloriesCategories.COL_NAME, name)
                cv.put(HealthDBContract.CaloriesCategories.COL_TYPE, type)
                hDatabase.insert(HealthDBContract.CaloriesCategories.TABLE_NAME, null, cv)
                hAdapter.swapCursor(getAllCategories())

                txtName.text.clear()
                txtType.text.clear()
                txtName.onEditorAction(EditorInfo.IME_ACTION_DONE);
                txtType.onEditorAction(EditorInfo.IME_ACTION_DONE);
            }
        }
    }

    private fun getAllCategories(): Cursor {
        return hDatabase.query(
            HealthDBContract.CaloriesCategories.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            HealthDBContract.CaloriesCategories.COL_TIMESTAMP + " DESC"
        );
    }

}