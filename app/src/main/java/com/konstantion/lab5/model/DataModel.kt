package com.konstantion.lab5.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_table")
data class DataModel(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String
)