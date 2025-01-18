package com.example.domain.usecase

import com.example.domain.data.Item
import com.example.domain.repository.ItemRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class FetchItemDetailsUseCaseTest {

    private val itemRepository: ItemRepository = mockk()
    private val fetchItemDetailsUseCase = FetchItemDetailsUseCase(itemRepository)

    @Test
    fun `fetchItemDetails should return list of items`() = runBlocking {
        // Arrange
        val mockItems = listOf(
            Item(id = 1, name = "Item 1", description = "Description 1", imageUrl = "url1.jpg", price = "10$"),
            Item(id = 2, name = "Item 2", description = "Description 2", imageUrl = "url2.jpg", price = "20$"))
        coEvery { itemRepository.fetchItemDetails() } returns mockItems

        // Act
        val result = fetchItemDetailsUseCase()

        // Assert
        assertEquals(mockItems, result)
    }
}
