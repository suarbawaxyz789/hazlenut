package com.example.hazelnut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.hazelnut.ui.features.authentication.AuthenticationViewModel

class MainActivity : ComponentActivity() {

    private val authenticationViewModel: AuthenticationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}
