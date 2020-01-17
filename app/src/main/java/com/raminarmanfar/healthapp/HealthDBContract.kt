package com.raminarmanfar.healthapp

import android.provider.BaseColumns

class HealthDBContract private constructor() {
    object CaloriesCategories : BaseColumns {
        const val TABLE_NAME = "caloriesCategories"
        const val COL_NAME = "name"
        const val COL_TYPE = "type"
        const val COL_DESC = "description"
        const val COL_TIMESTAMP = "timestamp"
    }
}