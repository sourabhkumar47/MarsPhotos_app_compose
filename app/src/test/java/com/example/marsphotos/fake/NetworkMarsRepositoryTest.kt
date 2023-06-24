package com.example.marsphotos.fake

import com.example.marsphotos.data.NetworkMarsPhotoRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

// Create an instance of the FakeMarsApiService
// Create an instance of the NetworkMarsPhotosRepository
// Call getMarsPhotos() on the NetworkMarsPhotosRepository
// Verify that the result matches the FakeDataSource.photosList

@Test
fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() =
    runTest {
        val repository = NetworkMarsPhotoRepository(
            marsApiService = FakeMarsApiService()
        )
        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
    }