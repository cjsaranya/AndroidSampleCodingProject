package com.example.codingtestsample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codingtestsample.data.ItemRepository
import com.example.codingtestsample.domain.Item
import com.example.codingtestsample.presentation.intents.ItemDetailsIntent
import com.example.codingtestsample.presentation.state.ItemDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemDetailsViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val _item = MutableStateFlow<Item?>(null)
    val item: StateFlow<Item?> = _item

    fun fetchItem(itemId: String) {
        viewModelScope.launch {
            _item.value = repository.getItemById(itemId.toInt())
        }
    }
}
