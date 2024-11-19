package com.konstantion.lab5.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "data_table")
data class DataModel(
    val userId: Int,
    @PrimaryKey val id: Int,
    val title: String,
    @SerializedName("body") val description: String
)