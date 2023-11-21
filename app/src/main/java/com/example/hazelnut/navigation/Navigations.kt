package com.example.hazelnut.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hazelnut.ui.features.authentication.Login
//import com.example.hazelnut.ui.features.landing.Landing

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { Login(navController = navController) }
//        composable("landing") { Landing(navController = navController) }
    }
}