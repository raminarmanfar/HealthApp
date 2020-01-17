package com.raminarmanfar.healthapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CaloriesCategoriesAdapter extends RecyclerView.Adapter<CaloriesCategoriesAdapter.CaloriesCategoryViewHolder> {

    private Context hContext;
    private Cursor hCursor;

    public CaloriesCategoriesAdapter(Context context, Cursor cursor) {
        this.hContext = context;
        this.hCursor = cursor;
    }

    public  class CaloriesCategoryViewHolder extends RecyclerView.ViewHolder {

        public TextView cateNameText;
        public TextView cateTypeText;
        public CaloriesCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            cateNameText = itemView.findViewById(R.id.txtNameItem);
            cateTypeText = itemView.findViewById(R.id.txtTypeItem);
        }
    }

    @NonNull
    @Override
    public CaloriesCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(hContext);
        View view = inflater.inflate(R.layout.fragment_calorie_item, parent, false);
        return new CaloriesCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CaloriesCategoryViewHolder holder, int position) {
        if(!hCursor.moveToPosition(position)) {
            return;
        }
        String name = hCursor.getString(hCursor.getColumnIndex(HealthDBContract.CaloriesCategories.COL_NAME));
        String type = hCursor.getString(hCursor.getColumnIndex(HealthDBContract.CaloriesCategories.COL_TYPE));

        holder.cateNameText.setText(name);
        holder.cateTypeText.setText(type);
    }

    @Override
    public int getItemCount() {
        return hCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if(hCursor != null) {
            hCursor.close();
        }

        hCursor = newCursor;
        if(newCursor != null) {
            notifyDataSetChanged();
        }
    }
}
