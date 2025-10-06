package com.example.dogapp.viewmodel

import com.example.dogapp.model.DogBreed
import com.example.dogapp.model.DogsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.thedogapi.com/v1/"

object DogsApiService{
    val dogApi = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(DogsApi::class.java)
    suspend fun getAll() = dogApi.getAllDogsBreed()
    suspend fun getImage(imageId: String) = dogApi.getImageById(imageId)
}