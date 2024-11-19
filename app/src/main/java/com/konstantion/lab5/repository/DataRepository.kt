package com.konstantion.lab5.repository

import androidx.lifecycle.LiveData
import com.konstantion.lab5.data.DataDao
import com.konstantion.lab5.model.DataModel
import com.konstantion.lab5.network.RetrofitClient

class DataRepository(private val dataDao: DataDao) {

    val allData: LiveData<List<DataModel>> = dataDao.getAllData()

    suspend fun insert(data: List<DataModel>) {
        dataDao.insertData(data)
    }

    suspend fun fetchDataFromApi() {
        try {
            val response = RetrofitClient.instance.fetchData()
            if (response.isSuccessful) {
                response.body()?.let { dataList ->
                    dataDao.insertData(dataList)
                }
            } else {
            }
        } catch (e: Exception) {
            throw IllegalStateException("This api call shouldn't fail.", e)
        }
    }

    suspend fun deleteAll() {
        dataDao.deleteAll()
    }
}