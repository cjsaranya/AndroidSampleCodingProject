package com.example.codingtestsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.codingtestsample.presentation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Setup Navigation
            val navController = rememberNavController()
            AppNavHost(navController = navController)  // Provide navController to NavHost
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    // Setup Navigation
    val navController = rememberNavController()
    AppNavHost(navController = navController)  // Provide navController to NavHost
}