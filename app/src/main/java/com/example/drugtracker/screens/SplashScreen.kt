package com.example.drugtracker.screens

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
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

    // Animation states
    var startAnimation by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.5f,
        animationSpec = tween(durationMillis = 800), label = "scale"
    )
    val alpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 800), label = "alpha"
    )

    // Start animation when screen appears
    LaunchedEffect(Unit) {
        startAnimation = true
        delay(1600) // Wait for animation + splash time
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
            .background(Color(0xFFE0EAFF))
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo with animation
        Image(
            painter = painterResource(id = R.drawable.splash_image),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(120.dp)
                .scale(scale)
                .alpha(alpha)
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
