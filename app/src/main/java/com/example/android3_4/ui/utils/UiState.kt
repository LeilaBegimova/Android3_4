package com.example.android3_4.ui.utils

data class UiState<T>(
    val isLoading:Boolean = true,
    val error:String? = null,
    val success:T? = null
)