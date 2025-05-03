//package com.example.drugtracker.screens
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Settings
//import androidx.compose.material3.Button
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//
//@Composable
//fun SplashScreen(navController: NavHostController) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(24.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Logo
//        Icon(
//            imageVector = Icons.Default.Settings, // Replace with your logo
//            contentDescription = "App Logo",
//            modifier = Modifier.size(120.dp),
//            tint = Color(0xFF5E35B1)
//        )
//
//        Spacer(modifier = Modifier.height(48.dp))
//
//        Button(
//            onClick = { navController.navigate("signup") },
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(50)
//        ) {
//            Text("Create New Account")
//        }
//
//        Spacer(modifier = Modifier.height(12.dp))
//
//        TextButton(onClick = { navController.navigate("login") }) {
//            Text("I already have an account")
//        }
//    }
//}
//
//package com.example.drugtracker.screens
//
//import android.util.Log
//import androidx.annotation.DrawableRes
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Settings
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.ColorFilter
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.example.drugtracker.R
//import com.google.firebase.auth.FirebaseAuth
//import kotlinx.coroutines.delay
//
//@Composable
//fun SplashScreen(navController: NavHostController) {
//    val auth = FirebaseAuth.getInstance()
//
//    // This LaunchedEffect runs once when the splash screen appears
//    LaunchedEffect(Unit) {
//        delay(2000)  // Optional: keep splash visible for 2 seconds
//        val user = auth.currentUser
//        if (user != null) {
//            // User is logged in
//            Log.d("SplashScreen", "User is logged in: ${user.email}")
//            navController.navigate("my_drugs") {
//                popUpTo("splash") { inclusive = true }  // Prevent back navigation to splash
//            }
//        } else {
//            // User is not logged in
//            Log.d("SplashScreen", "No user logged in")
//            navController.navigate("login") {
//                popUpTo("splash") { inclusive = true }
//            }
//        }
//    }
//
//    // Splash screen UI
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(24.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Logo (can be replaced with your actual logo)
//        Image(
//            painter = painterResource(id = R.drawable.splash_image), // replace 'logo' with your file name
//            contentDescription = "App Logo",
//            modifier = Modifier.size(120.dp), // optional if you want to tint
//        )
//
//        Spacer(modifier = Modifier.height(48.dp))
//
//        // Optional: show buttons only if you want user to skip waiting (can be removed)
//        Button(
//            onClick = { navController.navigate("signup") },
//            modifier = Modifier.fillMaxWidth(),
//            shape = RoundedCornerShape(50)
//        ) {
//            Text("Create New Account")
//        }
//
//        Spacer(modifier = Modifier.height(12.dp))
//
//        TextButton(onClick = { navController.navigate("login") }) {
//            Text("I already have an account")
//        }
//    }
//}
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.ColorFilter
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.example.drugtracker.R
//
//@Composable
//fun SplashScreen(navController: NavHostController) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFE0EAFF)) // Set background color
//            .padding(24.dp),
//        verticalArrangement = Arrangement.SpaceBetween, // Push content to top & bottom
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Spacer(modifier = Modifier.height(1.dp)) // Just to keep top empty
//
//        // Logo in the center
//        Image(
//            painter = painterResource(id = R.drawable.splash_image), // Replace with your image file
//            contentDescription = "App Logo",
//            modifier = Modifier.size(120.dp),
////            colorFilter = ColorFilter.tint(Color(0xFF5E35B1)) // Optional tint
//        )
//
//        // Bottom buttons
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Button(
//                onClick = { navController.navigate("signup") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(50.dp),
//                shape = RoundedCornerShape(50),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color(0xFF007AFF)
//                )
//            ) {
//                Text("Create New Account")
//            }
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            TextButton(onClick = { navController.navigate("login") }) {
//                Text(
//                    text = "I already have an account",
//                    color = Color(0xFF007AFF)
//                )
//            }
//        }
//    }
//}
package com.example.drugtracker.screens
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.drugtracker.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val auth = FirebaseAuth.getInstance()
    val currentUser = auth.currentUser

    // Navigate after a small delay (optional)
    LaunchedEffect(Unit) {
        delay(1000) // Optional: short delay for UX
        if (currentUser != null) {
            Log.d("SplashScreen", "User already logged in: ${currentUser.email}")
            navController.navigate("my_drugs") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }

    // UI Content
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0EAFF))  // Background color #E0EAFF
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.splash_image), // Replace with your image file
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp),
//            colorFilter = ColorFilter.tint(Color(0xFF5E35B1)) // Optional tint
        )
    }

    // Bottom buttons
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.navigate("signup") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF007AFF)
            )
        ) {
            Text("Create New Account")
        }
        Spacer(modifier = Modifier.height(12.dp))
        TextButton(onClick = { navController.navigate("login") }) {
            Text(
                text = "I already have an account",
                color = Color(0xFF007AFF)
            )
        }
    }
}
