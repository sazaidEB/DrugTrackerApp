package com.example.drugtracker.navigation

//import androidx.compose.runtime.Composable
//import androidx.hilt.navigation.compose.hiltViewModel
//
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.example.drugtracker.screens.DrugDetailScreen
//import com.example.drugtracker.screens.DrugSearchScreen
//import com.example.drugtracker.screens.LoginScreen
//import com.example.drugtracker.screens.MyDrugsScreen
//import com.example.drugtracker.screens.SignupScreen
//import com.example.drugtracker.screens.SplashScreen
//import com.example.drugtracker.viewmodel.DrugViewModel
//
//
//@Composable
//fun AppNavGraph(navController: NavHostController) {
//    val viewModel: DrugViewModel = hiltViewModel()
//
//    NavHost(navController = navController, startDestination = "splash") {
//        composable("login") {
//            LoginScreen(navController)
//        }
//        composable("signup") {
//            SignupScreen(navController)
//        }
//        composable("search") {
//            DrugSearchScreen(navController, viewModel)
//        }
//        composable("my_drugs") {
//            MyDrugsScreen(navController, viewModel)
//        }
//        composable("splash") {
//            SplashScreen(navController)
//        }
//        composable("detail/{rxcui}/{name}") { backStackEntry ->
//            val rxcui = backStackEntry.arguments?.getString("rxcui") ?: ""
//            val name = backStackEntry.arguments?.getString("name") ?: ""
//            DrugDetailScreen(navController, rxcui, name, viewModel)
//        }
//    }
//}



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

//@Composable
//fun AppNavGraph(navController: NavHostController) {
//    val viewModel: DrugViewModel = hiltViewModel()
//
//    NavHost(navController = navController, startDestination = "splash") {
//        composable("splash") {
//            SplashScreen(navController)
//        }
//        composable("login") {
//            LoginScreen(navController)
//        }
//        composable("signup") {
//            SignupScreen(navController)
//        }
//        composable("search") {
//            DrugSearchScreen(navController, viewModel)
//        }
//        composable("my_drugs") {
//            MyDrugsScreen(navController, viewModel)
//        }
//        composable("detail/{rxcui}/{name}") { backStackEntry ->
//            val rxcui = backStackEntry.arguments?.getString("rxcui") ?: ""
//            val name = backStackEntry.arguments?.getString("name")?.let {
//                URLDecoder.decode(it, StandardCharsets.UTF_8.toString())
//            } ?: ""
//            DrugDetailScreen(navController, rxcui, name, viewModel)
//        }
//    }
//}



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
