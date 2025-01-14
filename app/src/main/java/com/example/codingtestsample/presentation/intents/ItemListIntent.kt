package com.example.codingtestsample.presentation.intents

sealed class ItemListIntent {
    object FetchItems : ItemListIntent()
    data class SelectItem(val itemId: String) : ItemListIntent()
}
