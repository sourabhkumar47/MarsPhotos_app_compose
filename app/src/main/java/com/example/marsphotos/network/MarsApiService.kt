package com.example.marsphotos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

//data layer -> ViewModel uses to communicate with the web service.

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

//build and create a Retrofit object.
private val retrofit = Retrofit.Builder()
    //converter tells Retrofit what to do with the data it gets back from the web service
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

//Defines how Retrofit talks to the web server using HTTP requests.
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

//Object declaration
object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}