
package com.example.drugtracker.screens
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth

//@Composable
//fun LoginScreen(navController: NavHostController) {
//    val context = LocalContext.current
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var isLoading by remember { mutableStateOf(false) }
//
//    val auth = FirebaseAuth.getInstance()
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFE0EAFF))
//            .padding(24.dp)
//    ) {
//        // Top section: Login text and fields
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Spacer(modifier = Modifier.height(40.dp))
//            Text(
//                text = "Login",
//                style = MaterialTheme.typography.headlineMedium.copy(
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 24.sp
//                )
//            )
//            Spacer(modifier = Modifier.height(32.dp))
//
//            OutlinedTextField(
//                value = email,
//                onValueChange = { email = it },
//                label = { Text("Email") },
//                singleLine = true,
//                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//            )
//
//            OutlinedTextField(
//                value = password,
//                onValueChange = { password = it },
//                label = { Text("Password") },
//                singleLine = true,
//                visualTransformation = PasswordVisualTransformation(),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//            )
//        }
//
//        // Bottom section: Login button and Create account link
//        Column(
//            modifier = Modifier
//                .fillMaxSize(),
//            verticalArrangement = Arrangement.Bottom,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            if (isLoading) {
//                CircularProgressIndicator()
//            } else {
//                Button(
//                    onClick = {
//                        if (email.isNotBlank() && password.isNotBlank()) {
//                            isLoading = true
//                            auth.signInWithEmailAndPassword(email, password)
//                                .addOnCompleteListener { task ->
//                                    isLoading = false
//                                    if (task.isSuccessful) {
//                                        navController.navigate("my_drugs") {
//                                            popUpTo("login") { inclusive = true }
//                                        }
//                                    } else {
//                                        Toast.makeText(
//                                            context,
//                                            "Login failed: ${task.exception?.localizedMessage}",
//                                            Toast.LENGTH_SHORT
//                                        ).show()
//                                    }
//                                }
//                        } else {
//                            Toast.makeText(
//                                context,
//                                "Please fill in all fields.",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(50.dp),
//                    shape = MaterialTheme.shapes.large,
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color(0xFF007AFF)
//                    )
//                ) {
//                    Text("Log In", fontSize = 16.sp)
//                }
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            TextButton(onClick = { navController.navigate("signup") }) {
//                Text(
//                    text = "Create new account",
//                    style = MaterialTheme.typography.bodyMedium.copy(
//                        color = Color(0xFF007AFF)
//                    )
//                )
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))
//        }
//    }
//}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    val auth = FirebaseAuth.getInstance()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Login",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
            Spacer(modifier = Modifier.height(32.dp))

            // Email Field
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E3E7)) // light gray
            ) {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("Email", color = Color.Gray) },
                    singleLine = true,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        cursorColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            // Password Field
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E3E7)) // light gray
            ) {
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Password", color = Color.Gray) },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        cursorColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            } else {
                Button(
                    onClick = {
                        if (email.isNotBlank() && password.isNotBlank()) {
                            isLoading = true
                            auth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener { task ->
                                    isLoading = false
                                    if (task.isSuccessful) {
                                        navController.navigate("search") {
                                            popUpTo("login") { inclusive = true }
                                        }
                                    } else {
                                        Toast.makeText(
                                            context,
                                            "Login failed: ${task.exception?.localizedMessage}",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        } else {
                            Toast.makeText(
                                context,
                                "Please fill in all fields.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = MaterialTheme.shapes.large,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF007AFF)
                    )
                ) {
                    Text("Log In", fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = { navController.navigate("signup") }) {
                Text(
                    text = "Create new account",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFF007AFF)
                    )
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
