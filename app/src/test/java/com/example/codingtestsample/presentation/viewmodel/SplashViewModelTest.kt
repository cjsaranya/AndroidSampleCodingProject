package com.example.codingtestsample.presentation.viewmodel

import app.cash.turbine.test
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SplashViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun `initial state of isTimeoutCompleted is false`(): Unit = runTest {
        val viewModel = SplashViewModel()
        assertFalse(viewModel.isTimeoutCompleted.value)
    }

    @Test
    fun `isTimeoutCompleted emits correct values`() = runTest {
        val viewModel = SplashViewModel()

        viewModel.isTimeoutCompleted.test {
            assertEquals(false, awaitItem()) // Initial value
            advanceTimeBy(3000)
            assertEquals(true, awaitItem()) // After timeout
        }
    }
}