package com.techhands.newrickandmorty.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.techhands.newrickandmorty.SplashScreen
import com.techhands.newrickandmorty.utils.DASHBOARD_SCREEN
import com.techhands.newrickandmorty.utils.SPLASH_SCREEN

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SPLASH_SCREEN){

        composable(SPLASH_SCREEN){
            SplashScreen(navController = navController)
        }
        composable(DASHBOARD_SCREEN){

        }
    }
}