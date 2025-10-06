package com.example.dogapp.model

import com.google.gson.annotations.SerializedName

data class DogBreed(
    private val id: Int,
    private val weight: Measurement,
    private val height: Measurement,
    private val name: String,
    @SerializedName("life_span") private val _lifeSpan: String,
    @SerializedName("reference_image_id") private val _imageId: String,
    @SerializedName("bred_for") private val _bredFor: String,
    private var _imageUrl: String? = null
){

    val getId: Int get() = id
    val getWeight: String get() = weight.metric
    val getHeight: String get() = height.metric
    val getName: String get() = name
    val getLifeSpan: String get() = _lifeSpan
    val getImgId: String get() = _imageId
    val getBredFor: String get() = _bredFor
    var imageUrl: String
        get() = _imageUrl?: ""
        set(url) { _imageUrl = url}

}
data class Measurement(
    val metric: String
)
