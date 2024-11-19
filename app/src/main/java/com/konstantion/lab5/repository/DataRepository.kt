package com.konstantion.lab5.repository

import androidx.lifecycle.LiveData
import com.konstantion.lab5.data.DataDao
import com.konstantion.lab5.model.DataModel

class DataRepository(private val dataDao: DataDao) {

    val allData: LiveData<List<DataModel>> = dataDao.getAllData()

    suspend fun insert(data: List<DataModel>) {
        dataDao.insertData(data)
    }

    suspend fun deleteAll() {
        dataDao.deleteAll()
    }
}