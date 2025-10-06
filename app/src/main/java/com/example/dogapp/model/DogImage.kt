package com.example.dogapp.model

data class DogImage(
    private val id: String,
    private val url: String
) {
    val getId: String get() = id
    val getUrl: String get() = url
}