package com.example.codingtestsample.domain.repository

import com.example.codingtestsample.domain.Item


interface ItemRepository {
    suspend fun fetchItemDetails(): List<Item>
    fun getItemById(itemId: Int): Item?
}
