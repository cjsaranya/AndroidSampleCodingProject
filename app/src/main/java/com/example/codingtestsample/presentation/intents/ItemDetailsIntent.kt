package com.example.codingtestsample.presentation.intents

sealed class ItemDetailsIntent {
    data class FetchItem(val itemId: String) : ItemDetailsIntent()
}
