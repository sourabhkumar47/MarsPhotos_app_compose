package com.example.marsphotos.fake

import com.example.marsphotos.fake.rules.TestDispatcherRule
import com.example.marsphotos.ui.screens.MarsUiState
import com.example.marsphotos.ui.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {

    //to use testDispatcher thread instead of main thread
    @get:Rule
    val testDispatcherRule = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() = runTest {
        // Create an instance of the FakeNetworkMarsPhotosRepository
        // Create an instance of the MarsViewModel
        // Call getMarsPhotos() on the MarsViewModel
        // Verify that the result matches the FakeDataSource.photosList

        val marsViewModel = MarsViewModel(
            marsPhotosRepository = FakeNetworkMarsPhotosRepository()
        )
        assertEquals(
            MarsUiState.Success(
                "Success .${FakeDataSource.photosList.size} Mars " +
                        "photos retrieved"
            ),
            marsViewModel.marsUiState
        )

    }
}