package com.example.domain.usecase

import com.example.domain.data.Item
import com.example.domain.repository.ItemRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class GetItemByIdUseCaseTest {

    @Mock
    private lateinit var repository: ItemRepository

    private lateinit var getItemByIdUseCase: GetItemByIdUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        getItemByIdUseCase = GetItemByIdUseCase(repository)
    }

    @Test
    fun `invoke should return the correct item when item exists`() = runTest {
        // Arrange
        val itemId = 1
        val expectedItem = Item(id = 1, name = "Item 1", description = "Description 1", imageUrl = "url1.jpg", price = "10$")

        `when`(repository.getItemById(itemId)).thenReturn(expectedItem)

        // Act
        val result = getItemByIdUseCase(itemId)

        // Assert
        assertEquals(expectedItem, result)
    }

    @Test
    fun `invoke should return null when item does not exist`() = runTest {
        // Arrange
        val itemId = 1
        `when`(repository.getItemById(itemId)).thenReturn(null)

        // Act
        val result = getItemByIdUseCase(itemId)

        // Assert
        assertEquals(null, result)
    }
}

