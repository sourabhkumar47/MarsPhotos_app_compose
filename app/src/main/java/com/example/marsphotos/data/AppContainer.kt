package com.example.marsphotos.data

import com.example.marsphotos.network.MarsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val marsPhotosRepository: MarsPhotosRepository
}

class DefaultContainer : AppContainer {

    //BASE_URL is the base URL of the web service.
    private val baseUrl =
        "https://android-kotlin-fun-mars-server.appspot.com"

    /**
    retrofit is the object that Retrofit uses to execute HTTP requests.
    Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit = Retrofit.Builder()
        //converter tells Retrofit what to do with the data it gets back from the web service
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    //retrofitService
    private val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(retrofitService)
    }
}