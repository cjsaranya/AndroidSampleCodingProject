package com.example.codingtestsample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.data.Item
import com.example.domain.usecase.FetchItemDetailsUseCase
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
    private val fetchItemDetailsUseCase: FetchItemDetailsUseCase
) : ViewModel() {

    private val _items = MutableStateFlow<List<Item>>(emptyList())
    val items: StateFlow<List<Item>> = _items

    private val _uiState = MutableStateFlow<ItemListState>(ItemListState.Loading)
    val uiState: StateFlow<ItemListState> = _uiState

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            _uiState.value = try {
                _items.value = fetchItemDetailsUseCase.invoke()
                ItemListState.Success(_items.value)
            } catch (e: Exception) {
                ItemListState.Error("Failed to fetch items")
            }
        }
    }
    private fun fetchItems1() {
        viewModelScope.launch {
        }
    }

}
