package com.konstantion.lab5.network

import com.konstantion.lab5.model.DataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun fetchData(): Response<List<DataModel>>
}
