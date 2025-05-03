//package com.example.drugtracker.screens
////import android.content.Intent
////import android.provider.CalendarContract
////import androidx.compose.foundation.layout.*
////import androidx.compose.material3.*
////import androidx.compose.runtime.Composable
////import androidx.compose.runtime.LaunchedEffect
////import androidx.compose.runtime.collectAsState
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.platform.LocalContext
////import androidx.compose.ui.unit.dp
////import androidx.navigation.NavHostController
////import com.example.drugtracker.viewmodel.DrugViewModel
//
////@Composable
////fun DrugDetailScreen(navController: NavHostController, rxcui: String, name: String, viewModel: DrugViewModel) {
////    val context = LocalContext.current
////    val detailText = viewModel.drugDetail.collectAsState().value
////
////    LaunchedEffect(Unit) {
////        viewModel.fetchDrugDetail(rxcui)
////    }
////
////    Column(
////        modifier = Modifier
////            .fillMaxSize()
////            .padding(16.dp)
////    ) {
////        Text(name, style = MaterialTheme.typography.headlineMedium)
////        Spacer(Modifier.height(8.dp))
////        Text("RXCUI: $rxcui", style = MaterialTheme.typography.bodySmall)
////        Spacer(Modifier.height(16.dp))
////        Text(detailText, style = MaterialTheme.typography.bodyMedium)
////        Spacer(Modifier.height(24.dp))
////        Button(onClick = {
////            val intent = Intent(Intent.ACTION_INSERT).apply {
////                data = CalendarContract.Events.CONTENT_URI
////                putExtra(CalendarContract.Events.TITLE, "Take $name")
////            }
////            context.startActivity(intent)
////        }, modifier = Modifier.fillMaxWidth()) {
////            Text("Add Reminder")
////        }
////    }
////}
//
//
//
//import android.widget.Toast
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import com.example.drugtracker.data.DrugEntity
//import com.example.drugtracker.viewmodel.DrugViewModel
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DrugDetailScreen(
//    navController: NavHostController,
//    rxcui: String,
//    name: String,
//    viewModel: DrugViewModel
//) {
//    val context = LocalContext.current
//    val drugDetail by viewModel.drugDetail.collectAsState()
//
//    LaunchedEffect(rxcui) {
//        viewModel.fetchDrugDetail(rxcui)
//    }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(name) },
//                navigationIcon = {
//                    IconButton(onClick = { navController.popBackStack() }) {
//                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
//                    }
//                }
//            )
//        },
//        bottomBar = {
//            // Add button clearly visible at the bottom
//            Button(
//                onClick = {
//                    viewModel.addDrug(
//                        DrugEntity(rxcui = rxcui, name = name),
//                        onLimitExceeded = {
//                            Toast.makeText(
//                                context,
//                                "Limit: Max 3 drugs can be added.",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    )
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Text("Add Medicine to My List")
//            }
//        }
//    ) { paddingValues ->
//        // Scrollable details area
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues)
//                .padding(16.dp)
//                .verticalScroll(rememberScrollState()),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.Start
//        ) {
//            Text("Drug Details:", style = MaterialTheme.typography.titleMedium)
//            Spacer(Modifier.height(8.dp))
//            Text(
//                text = drugDetail,
//                style = MaterialTheme.typography.bodyMedium
//            )
//        }
//    }
//}
//

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.drugtracker.R
import com.example.drugtracker.data.DrugEntity
import com.example.drugtracker.viewmodel.DrugViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrugDetailScreen(
    navController: NavHostController,
    rxcui: String,
    name: String,
    viewModel: DrugViewModel
) {
    val context = LocalContext.current
    val drugDetail by viewModel.drugDetail.collectAsState()

    LaunchedEffect(rxcui) {
        viewModel.fetchDrugDetail(rxcui)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 48.dp),  // Compensate for the back arrow's width
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Details")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )

        },
        bottomBar = {
            Button(
                onClick = {
                    viewModel.addDrug(
                        DrugEntity(rxcui = rxcui, name = name),
                        onLimitExceeded = {
                            Toast.makeText(
                                context,
                                "Limit: Max 3 drugs can be added.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(30),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF007AFF)
                )
            ) {
                Text("Add Medication to List")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF2F2F6))
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            // Medicine image
            Image(
                painter = painterResource(id = R.drawable.img), // replace with your icon
                contentDescription = "Medicine Icon",
                modifier = Modifier
                    .size(60.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))

            // Medicine name
            Text(
                text = "Medicine 1",
                style = MaterialTheme.typography.titleLarge
            )
            // Generic subtitle
            Text(
                text = "Generic Name",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Details card
            Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Details"
                        ,
                        color = Color.Gray,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = name,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
