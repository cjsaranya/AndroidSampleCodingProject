package com.example.codingtestsample.domain.usecase

import com.example.codingtestsample.domain.Item
import com.example.codingtestsample.domain.repository.ItemRepository
import javax.inject.Inject

class GetItemByIdUseCase @Inject constructor(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(itemId: Int): Item? {
        return repository.getItemById(itemId)
    }
}
