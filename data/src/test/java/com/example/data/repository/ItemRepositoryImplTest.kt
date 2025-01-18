package com.example.data.repository

import com.example.data.remote.ApiService
import com.example.domain.data.Item
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class ItemRepositoryImplTest {

    @Mock
    private lateinit var apiService: ApiService

    private lateinit var itemRepository: ItemRepositoryImpl

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        itemRepository = ItemRepositoryImpl(apiService)
    }

    @Test
    fun `fetchItemDetails should return items from ApiService`() = runTest {
        // Arrange
        val mockItems = listOf(
            Item(id = 1, name = "Item 1", description = "Description 1", imageUrl = "url1.jpg", price = "10$"),
            Item(id = 2, name = "Item 2", description = "Description 2", imageUrl = "url2.jpg", price = "20$")
        )
        `when`(apiService.getItemDetails()).thenReturn(mockItems)

        // Act
        val result = itemRepository.fetchItemDetails()

        // Assert
        assertEquals(mockItems, result)
        verify(apiService).getItemDetails()
    }

    @Test
    fun `fetchItemDetails should return an empty list when ApiService returns null`() = runTest {
        // Arrange
        `when`(apiService.getItemDetails()).thenReturn(null)

        // Act
        val result = itemRepository.fetchItemDetails()

        // Assert
        assertEquals(emptyList<Item>(), result)
        verify(apiService).getItemDetails()
    }

    @Test
    fun `getItemById should return the correct item from cache`() = runTest {
        // Arrange
        val mockItems = listOf(
            Item(id = 1, name = "Item 1", description = "Description 1", imageUrl = "url1.jpg", price = "10$"),
            Item(id = 2, name = "Item 2", description = "Description 2", imageUrl = "url2.jpg", price = "20$")      )
        `when`(apiService.getItemDetails()).thenReturn(mockItems)

        // Populate cache
        itemRepository.fetchItemDetails()

        // Act
        val result = itemRepository.getItemById(1)

        // Assert
        assertEquals(mockItems[0], result)
    }

    @Test
    fun `getItemById should return null when item is not in cache`() = runTest {
        // Arrange
        val mockItems = listOf(
            Item(id = 1, name = "Item 1", description = "Description 1", imageUrl = "url1.jpg", price = "10$"),
            Item(id = 2, name = "Item 2", description = "Description 2", imageUrl = "url2.jpg", price = "20$"))

        `when`(apiService.getItemDetails()).thenReturn(mockItems)

        // Populate cache
        itemRepository.fetchItemDetails()

        // Act
        val result = itemRepository.getItemById(3)

        // Assert
        assertEquals(null, result)
    }
}
