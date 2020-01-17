package com.raminarmanfar.healthapp;

import android.provider.BaseColumns;

public class HealthDBContract {

    private HealthDBContract () {}

    public static final class CaloriesCategories implements BaseColumns {
        public static final  String TABLE_NAME = "caloriesCategories";
        public static final  String COL_NAME = "name";
        public static final  String COL_TYPE = "type";
        public static final  String COL_DESC = "description";
        public static final  String COL_TIMESTAMP = "timestamp";
    }
}
