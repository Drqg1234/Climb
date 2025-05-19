package com.example.climb

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.loginScreen){
        composable(Routes.loginScreen,){
            LoginScreen(navController)
        }
        composable(Routes.homeScreen + "/{name}",){ backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            HomeScreen(navController, name?: "no name given")
        }
    }
}