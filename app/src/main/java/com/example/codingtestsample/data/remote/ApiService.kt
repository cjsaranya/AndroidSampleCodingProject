package com.example.codingtestsample.data.remote

import com.example.codingtestsample.domain.Item
import retrofit2.http.GET

interface ApiService {
    @GET("866592d4df655060f42c")
    suspend fun getItemDetails(): List<Item>
}
