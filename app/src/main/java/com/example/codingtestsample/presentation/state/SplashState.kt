package com.example.codingtestsample.presentation.state

sealed class SplashState {
    object Loading : SplashState()
    object TimeoutCompleted : SplashState()
}
