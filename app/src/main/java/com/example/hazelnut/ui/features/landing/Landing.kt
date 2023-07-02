package com.example.hazelnut.ui.features.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.hazelnut.ui.theme.widgets.PageContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Landing(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        topBar = { MyAppBar() },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            PageContainer {
                Text(text = "test")
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "My App", style = MaterialTheme.typography.titleLarge.copy(
                    color = Color.White
                )
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}