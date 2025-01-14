package com.example.codingtestsample.presentation.viewmodel

import com.example.codingtestsample.data.ItemRepository
import com.example.codingtestsample.domain.Item
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ItemDetailsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: ItemDetailsViewModel
    private val repository: ItemRepository = mockk()

    @Before
    fun setUp() {
        viewModel = ItemDetailsViewModel(repository)
    }

    @Test
    fun `item flow is null initially`() {
        assertNull(viewModel.item.value)
    }

    @Test
    fun `fetchItem updates item flow with repository result`() = runTest {
        val testItem = Item(id = 1, name = "Test Item", description = "Test Description", imageUrl = "test.jpg", price = "30$")
        coEvery { repository.getItemById(1) } returns testItem

        viewModel.fetchItem("1")

        assertEquals(testItem, viewModel.item.value)
    }
    @Test
    fun `fetchItem updates item flow correctly on multiple calls`() = runTest {
        val firstItem = Item(id = 1, name = "Item 1", description = "Description 1", imageUrl = "url1.jpg", price = "10$")
        val secondItem = Item(id = 2, name = "Item 2", description = "Description 2", imageUrl = "url2.jpg", price = "20$")

        coEvery { repository.getItemById(1) } returns firstItem
        coEvery { repository.getItemById(2) } returns secondItem

        viewModel.fetchItem("1")
        assertEquals(firstItem, viewModel.item.value)

        viewModel.fetchItem("2")
        assertEquals(secondItem, viewModel.item.value)
    }

    @Test
    fun `fetchItem calls repository with correct ID`() = runTest {
        coEvery { repository.getItemById(1) } returns null

        viewModel.fetchItem("1")

        coVerify { repository.getItemById(1) } // Verify the correct ID was passed.
    }

    @Test
    fun `fetchItem with large or negative ID handles correctly`() = runTest {
        coEvery { repository.getItemById(-1) } returns null
        coEvery { repository.getItemById(Int.MAX_VALUE) } returns null

        viewModel.fetchItem("-1")
        assertNull(viewModel.item.value)

        viewModel.fetchItem(Int.MAX_VALUE.toString())
        assertNull(viewModel.item.value)
    }

}