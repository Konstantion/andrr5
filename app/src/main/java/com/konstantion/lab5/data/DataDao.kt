package com.konstantion.lab5.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.konstantion.lab5.model.DataModel

@Dao
interface DataDao {

    @Query("SELECT * FROM data_table")
    fun getAllData(): LiveData<List<DataModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: List<DataModel>)

    @Query("DELETE FROM data_table")
    suspend fun deleteAll()
}