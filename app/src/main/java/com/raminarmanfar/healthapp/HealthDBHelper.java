package com.raminarmanfar.healthapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HealthDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Health.db";
    public static final int DATABASE_VERSION = 1;

    public HealthDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_CALORIE_CATEGORIES_TABLE = "CREATE TABLE " +
                HealthDBContract.CaloriesCategories.TABLE_NAME + " (" +
                HealthDBContract.CaloriesCategories._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HealthDBContract.CaloriesCategories.COL_NAME + " TEXT NOT NULL, " +
                HealthDBContract.CaloriesCategories.COL_TYPE + " TEXT NOT NULL, " +
                HealthDBContract.CaloriesCategories.COL_DESC + " TEXT, " +
                HealthDBContract.CaloriesCategories.COL_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";
        db.execSQL(SQL_CREATE_CALORIE_CATEGORIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + HealthDBContract.CaloriesCategories.TABLE_NAME);
        onCreate(db);
    }
}
