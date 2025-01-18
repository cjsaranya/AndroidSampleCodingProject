package com.example.data.repository

import com.example.data.remote.ApiService
import com.example.domain.data.Item
import com.example.domain.repository.ItemRepository
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ItemRepository {

    private var cachedItems: List<Item>? = null

    override suspend fun fetchItemDetails(): List<Item> {
        cachedItems = apiService.getItemDetails()
        return cachedItems ?: emptyList()
    }

    override fun getItemById(itemId: Int): Item? {
        return cachedItems?.find { it.id == itemId }
    }
}