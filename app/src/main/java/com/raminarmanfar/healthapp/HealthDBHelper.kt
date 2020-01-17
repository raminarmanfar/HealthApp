package com.raminarmanfar.healthapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.raminarmanfar.healthapp.HealthDBContract.CaloriesCategories

class HealthDBHelper(context: Context?) : SQLiteOpenHelper(
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {
    override fun onCreate(db: SQLiteDatabase) {
        val SQL_CREATE_CALORIE_CATEGORIES_TABLE = "CREATE TABLE " +
                CaloriesCategories.TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CaloriesCategories.COL_NAME + " TEXT NOT NULL, " +
                CaloriesCategories.COL_TYPE + " TEXT NOT NULL, " +
                CaloriesCategories.COL_DESC + " TEXT, " +
                CaloriesCategories.COL_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");"
        db.execSQL(SQL_CREATE_CALORIE_CATEGORIES_TABLE)
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS " + CaloriesCategories.TABLE_NAME)
        onCreate(db)
    }

    companion object {
        const val DATABASE_NAME = "Health.db"
        const val DATABASE_VERSION = 1
    }
}