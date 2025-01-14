package com.example.codingtestsample.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingtestsample.data.ItemRepository
import com.example.codingtestsample.domain.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class ItemListState {
    data object Loading : ItemListState()
    data class Success(val items: List<Item>) : ItemListState()
    data class Error(val message: String) : ItemListState()
}

@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val repository: ItemRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<ItemListState>(ItemListState.Loading)
    val uiState: StateFlow<ItemListState> = _uiState

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            _uiState.value = try {
                val items = repository.fetchItemDetails()
                ItemListState.Success(items)
            } catch (e: Exception) {
                ItemListState.Error("Failed to fetch items")
            }
        }
    }
}
