package com.example.dogapp.model

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DogsApi {
    @GET("/breeds")
    suspend fun getAllDogsBreed(
        @Query("limit") limit: Int = 30,
        @Query("page") page: Int = 0
    ): List<DogBreed>

    @GET("/images/{image_id}")
    suspend fun getImageById(@Path("image_id") imageId: String): DogImage
}