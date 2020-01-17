package com.raminarmanfar.healthapp

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raminarmanfar.healthapp.CaloriesCategoriesAdapter.CaloriesCategoryViewHolder
import com.raminarmanfar.healthapp.HealthDBContract.CaloriesCategories

class CaloriesCategoriesAdapter(
    private val hContext: Context?,
    private var hCursor: Cursor?
) : RecyclerView.Adapter<CaloriesCategoryViewHolder>() {

    inner class CaloriesCategoryViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var cateNameText: TextView
        var cateTypeText: TextView

        init {
            cateNameText = itemView.findViewById(R.id.txtNameItem)
            cateTypeText = itemView.findViewById(R.id.txtTypeItem)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CaloriesCategoryViewHolder {
        val inflater = LayoutInflater.from(hContext)
        val view =
            inflater.inflate(R.layout.fragment_calorie_item, parent, false)
        return CaloriesCategoryViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CaloriesCategoryViewHolder,
        position: Int
    ) {
        if (!hCursor!!.moveToPosition(position)) {
            return
        }
        val name =
            hCursor!!.getString(hCursor!!.getColumnIndex(CaloriesCategories.COL_NAME))
        val type =
            hCursor!!.getString(hCursor!!.getColumnIndex(CaloriesCategories.COL_TYPE))
        holder.cateNameText.text = name
        holder.cateTypeText.text = type
    }

    override fun getItemCount(): Int {
        return hCursor!!.count
    }

    fun swapCursor(newCursor: Cursor?) {
        if (hCursor != null) {
            hCursor!!.close()
        }
        hCursor = newCursor
        if (newCursor != null) {
            notifyDataSetChanged()
        }
    }

}