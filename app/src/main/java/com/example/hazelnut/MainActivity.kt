package com.example.hazelnut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.hazelnut.navigation.AppNavigation
import com.example.hazelnut.ui.features.authentication.AuthenticationViewModel
//import com.example.hazelnut.ui.theme.HazelnutTheme

class MainActivity : ComponentActivity() {

    private val authenticationViewModel: AuthenticationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            HazelnutTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier
//                        .fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    AppNavigation()
//                }
//            }
        }
    }
}
