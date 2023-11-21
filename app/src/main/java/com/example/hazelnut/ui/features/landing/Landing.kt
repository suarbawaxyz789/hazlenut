package com.example.hazelnut.ui.features.landing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//import androidx.compose.material.ExperimentalmaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
//import androidx.compose.material.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.hazelnut.ui.theme.widgets.PageContainer
//
//@OptIn(ExperimentalmaterialApi::class)
//@Composable
//fun Landing(modifier: Modifier = Modifier, navController: NavController) {
//    Scaffold(
//        topBar = { MyAppBar() },
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .padding(paddingValues)
//                .fillMaxSize()
//        ) {
//            PageContainer {
//                Text(text = "test")
//            }
//        }
//    }
//}
//
//
//@OptIn(ExperimentalmaterialApi::class)
//@Composable
//fun MyAppBar() {
//    TopAppBar(
//        title = {
//            Text(
//                text = "My App", style = MaterialTheme.typography.titleLarge.copy(
//                    color = Color.White
//                )
//            )
//        },
//        colors = TopAppBarDefaults.smallTopAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primary
//        )
//    )
//}