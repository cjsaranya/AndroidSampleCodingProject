package com.example.codingtestsample.presentation.state

import com.example.codingtestsample.domain.Item

sealed class ItemDetailsState {
    object Loading : ItemDetailsState()
    data class Success(val item: Item) : ItemDetailsState()
    data class Error(val message: String) : ItemDetailsState()
}
