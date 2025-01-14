package com.example.codingtestsample.data

import com.example.codingtestsample.data.remote.ApiService
import com.example.codingtestsample.domain.Item
import javax.inject.Inject

class ItemRepository @Inject constructor(private val apiService: ApiService) {

    private var cachedItems: List<Item>? = null

    // Fetch items from API and cache them
    suspend fun fetchItemDetails(): List<Item> {
        cachedItems = apiService.getItemDetails()
        return cachedItems ?: emptyList()
    }

    // Retrieve a specific item by ID from the cached list
    fun getItemById(itemId: Int): Item? {
        return cachedItems?.find { it.id == itemId }
    }
}
