package com.example.drugtracker.screens

import androidx.compose.foundation.Image
import com.example.drugtracker.viewmodel.DrugViewModel


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // ✅ ensure this import
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.drugtracker.R

import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun MyDrugsScreen(
//    navController: NavHostController,
//    viewModel: DrugViewModel = hiltViewModel()
//) {
//    val userDrugs by viewModel.userDrugs.collectAsState(initial = emptyList())
//    val scope = rememberCoroutineScope()
//
//    LaunchedEffect(Unit) {
//        viewModel.getUserDrugs()
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        if (userDrugs.isEmpty()) {
//            // Center message when no drugs
//            Column(
//                modifier = Modifier
//                    .fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    text = "No medications found.",
//                    style = MaterialTheme.typography.bodyLarge
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                TextButton(
//                    onClick = {
//                        navController.navigate("search")
//                    }
//                ) {
//                    Text(
//                        text = "Search Medications",
//                        style = MaterialTheme.typography.titleMedium.copy(
//                            color = MaterialTheme.colorScheme.primary
//                        )
//                    )
//                }
//            }
//        } else {
//            // List of user drugs
//            Column(modifier = Modifier.fillMaxSize()) {
//                LazyColumn(
//                    modifier = Modifier.weight(1f)
//                ) {
//                    items(
//                        items = userDrugs,
//                        key = { drug -> drug.id }
//                    ) { drug ->
//                        val dismissState = rememberDismissState(
//                            confirmStateChange = { dismissValue ->
//                                if (dismissValue == DismissValue.DismissedToStart ||
//                                    dismissValue == DismissValue.DismissedToEnd
//                                ) {
//                                    scope.launch {
//                                        viewModel.deleteDrug(drug)
//                                    }
//                                }
//                                true
//                            }
//                        )
//
//                        SwipeToDismiss(
//                            state = dismissState,
//                            directions = setOf(
//                                DismissDirection.StartToEnd,
//                                DismissDirection.EndToStart
//                            ),
//                            background = {
//                                val color = when (dismissState.dismissDirection) {
//                                    DismissDirection.StartToEnd, DismissDirection.EndToStart -> Color.Red
//                                    null -> Color.Transparent
//                                }
//                                Box(
//                                    modifier = Modifier
//                                        .fillMaxSize()
//                                        .background(color)
//                                        .padding(16.dp)
//                                )
//                            },
//                            dismissContent = {
//
//                                Card(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(vertical = 6.dp)
//                                        .height(60.dp),
////                                        .clickable {
////                                            val encodedName = URLEncoder.encode(drug.name, StandardCharsets.UTF_8.toString())
////                                            navController.navigate("detail/${drug.rxcui}/$encodedName")
////                                        },
//                                    shape = RoundedCornerShape(12.dp),
//                                    colors = CardDefaults.cardColors(containerColor = Color.White) // Set white background
//                                ) {
//                                    Row(
//                                        verticalAlignment = Alignment.CenterVertically,
//                                        modifier = Modifier
//                                            .fillMaxWidth()
//                                            .padding(16.dp)
//                                    ) {
//                                        // Medicine icon - replace R.drawable.medicine_icon with your drawable
//                                        Image(
//                                            painter = painterResource(id = R.drawable.img),
//                                            contentDescription = "Medicine Icon",
//                                            modifier = Modifier
//                                                .size(48.dp)
//                                                .clip(CircleShape)
//                                        )
//
//                                        Spacer(modifier = Modifier.width(10.dp))
//
//                                        Text(
//                                            text = drug.name,
//                                            style = MaterialTheme.typography.titleMedium,
//                                            modifier = Modifier.weight(1f)
//                                        )
//
//                                        Icon(
//                                            imageVector = Icons.Default.KeyboardArrowRight,
//                                            tint = Color.Gray
//                                            ,
//                                            contentDescription = "Go to details"
//                                        )
//                                    }
//                                }
//                            }
//                        )
//                    }
//                }
//
//                // Search Medications button at the bottom
//                TextButton(
//                    onClick = {
//                        navController.navigate("search")
//                    },
//                    modifier = Modifier
//                        .align(Alignment.CenterHorizontally)
//                        .padding(16.dp)
//                ) {
//                    Text(
//                        text = "Search Medications",
//                        style = MaterialTheme.typography.titleMedium.copy(
//                            color = MaterialTheme.colorScheme.primary
//                        )
//                    )
//                }
//            }
//        }
//    }
//}
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MyDrugsScreen(
    navController: NavHostController,
    viewModel: DrugViewModel = hiltViewModel()
) {
    val userDrugs by viewModel.userDrugs.collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        viewModel.getUserDrugs()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start, // Align to the right
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "My Medications",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(10.dp)

                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(onClick = {
                            // Add action if needed
                        }) {
                        }
                    }
                },

            )
        },
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                if (userDrugs.isEmpty()) {
                    // Center message when no drugs
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "No medications found.",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        TextButton(
                            onClick = {
                                navController.navigate("search")
                            }
                        ) {
                            Text(
                                text = "Search Medications",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    color = MaterialTheme.colorScheme.primary
                                )
                            )
                        }
                    }
                } else {
                    // List of user drugs
                    Column(modifier = Modifier.fillMaxSize()) {
                        LazyColumn(
                            modifier = Modifier.weight(1f)
                        ) {
                            items(
                                items = userDrugs,
                                key = { drug -> drug.id }
                            ) { drug ->
                                val dismissState = rememberDismissState(
                                    confirmStateChange = { dismissValue ->
                                        if (dismissValue == DismissValue.DismissedToStart ||
                                            dismissValue == DismissValue.DismissedToEnd
                                        ) {
                                            scope.launch {
                                                viewModel.deleteDrug(drug)
                                            }
                                        }
                                        true
                                    }
                                )

                                SwipeToDismiss(
                                    state = dismissState,
                                    directions = setOf(
                                        DismissDirection.StartToEnd,
                                        DismissDirection.EndToStart
                                    ),
                                    background = {
                                        val color = when (dismissState.dismissDirection) {
                                            DismissDirection.StartToEnd, DismissDirection.EndToStart -> Color.Red
                                            null -> Color.Transparent
                                        }
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(color)
                                                .padding(16.dp)
                                        )
                                    },
                                    dismissContent = {
                                        Card(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(vertical = 6.dp)
                                                .height(60.dp),
                                            shape = RoundedCornerShape(12.dp),
                                            colors = CardDefaults.cardColors(containerColor = Color.White)
                                        ) {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(16.dp)
                                            ) {
                                                Image(
                                                    painter = painterResource(id = R.drawable.img),
                                                    contentDescription = "Medicine Icon",
                                                    modifier = Modifier
                                                        .size(48.dp)
                                                        .clip(CircleShape)
                                                )

                                                Spacer(modifier = Modifier.width(10.dp))

                                                Text(
                                                    text = drug.name,
                                                    style = MaterialTheme.typography.titleMedium,
                                                    modifier = Modifier.weight(1f)
                                                )

                                                Icon(
                                                    imageVector = Icons.Default.KeyboardArrowRight,
                                                    tint = Color.Gray,
                                                    contentDescription = "Go to details"
                                                )
                                            }
                                        }
                                    }
                                )
                            }
                        }

                        // Search Medications button at the bottom
                        TextButton(
                            onClick = {
                                navController.navigate("search")
                            },
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(16.dp)
                        ) {
//                            Text(
//                                text = "Search Medications",
//                                style = MaterialTheme.typography.titleMedium.copy(
//                                    color = MaterialTheme.colorScheme.primary
//                                )
//                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    // This shows the + icon
                                    contentDescription = "Add Icon",
                                    tint = (Color(0xFF007AFF)),
                                    modifier = Modifier.size(18.dp) // You can adjust size as needed
                                )
                                Spacer(modifier = Modifier.width(6.dp)) // Adds spacing between the icon and text
                                Text(
                                    text = "Search Medication",
                                    color =(Color(0xFF007AFF))
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}
