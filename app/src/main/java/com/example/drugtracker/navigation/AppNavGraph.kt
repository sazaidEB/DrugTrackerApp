package com.example.drugtracker.navigation
import DrugDetailScreen
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.drugtracker.screens.*
import com.example.drugtracker.viewmodel.DrugViewModel
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun AppNavGraph(navController: NavHostController) {
    val viewModel: DrugViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = "splash") {
        // Splash Screen
        composable("splash") {
            SplashScreen(navController)
        }

        // Login Screen
        composable("login") {
            LoginScreen(navController)
        }

        // Signup Screen
        composable("signup") {
            SignupScreen(navController)
        }

        // Drug Search Screen
        composable("search") {
            DrugSearchScreen(navController, viewModel)
        }

        // My Medications List Screen
        composable("my_drugs") {
            MyDrugsScreen(navController, viewModel)
        }

        // Drug Detail Screen
        composable("detail/{rxcui}/{name}") { backStackEntry ->
            val rxcui = backStackEntry.arguments?.getString("rxcui") ?: ""
            val name = backStackEntry.arguments?.getString("name")?.let {
                URLDecoder.decode(it, StandardCharsets.UTF_8.toString())
            } ?: ""
            DrugDetailScreen(navController, rxcui, name, viewModel)
        }
    }
}
