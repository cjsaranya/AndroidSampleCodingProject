package com.example.codingtestsample.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.codingtestsample.presentation.intents.SplashIntent
import com.example.codingtestsample.presentation.state.SplashState
import com.example.codingtestsample.presentation.viewmodel.SplashViewModel

@Composable
fun SplashScreen(viewModel: SplashViewModel = hiltViewModel(), onTimeout: () -> Unit) {
    val isTimeoutCompleted by viewModel.isTimeoutCompleted.collectAsState()

    LaunchedEffect(isTimeoutCompleted) {
        if (isTimeoutCompleted) {
            onTimeout()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "My App",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
        )
    }
}