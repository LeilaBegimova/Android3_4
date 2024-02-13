package com.example.android3_4.data.model


import com.google.gson.annotations.SerializedName

data class PockemonResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<Result>
)