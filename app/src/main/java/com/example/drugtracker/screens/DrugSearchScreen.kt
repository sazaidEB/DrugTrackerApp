package com.example.drugtracker.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.example.drugtracker.R
import com.example.drugtracker.viewmodel.DrugViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrugSearchScreen(navController: NavHostController, viewModel: DrugViewModel) {
    var query by remember { mutableStateOf("") }
    val searchResults by viewModel.searchResults.collectAsState()
    val isQueryValid = query.isNotBlank()
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(modifier = Modifier.fillMaxSize()
    ) {
        // Top bar with Back and Title
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Search Medication",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFE5E5EA))
                .height(44.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            if (query.isEmpty()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Search Medication",
                        color = Color.Gray
                    )
                }
            }
            BasicTextField(
                value = query,
                onValueChange = { query = it },
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp)
                    .align(Alignment.CenterStart),
                decorationBox = { innerTextField ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (query.isNotEmpty()) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon",
                                tint = Color.Gray
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                        }
                        innerTextField()
                    }
                }
            )
        }


//        OutlinedTextField(
//            value = query,
//            onValueChange = { query = it },
//            placeholder = {
//                Text(
//                    text = "Search Medication",
//                    modifier = Modifier.fillMaxWidth(),
//                    maxLines = 1
//                )
//            },
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Default.Search,
//                    contentDescription = "Search Icon",
//                    tint = Color.Gray
//                )
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp)
//                .clip(RoundedCornerShape(10.dp))
//                .background(Color(0xFFE5E5EA)) // 👈 Light gray background
//                .height(44.dp), // iOS-like height
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                containerColor = Color.Transparent,
//                focusedBorderColor = Color.Transparent,
//                unfocusedBorderColor = Color.Transparent,
//                disabledBorderColor = Color.Transparent,
//                unfocusedTextColor = Color.Black,
//                focusedPlaceholderColor = Color.Gray,
//            ),
//            singleLine = true,
//            textStyle = LocalTextStyle.current.copy(
//                fontSize = MaterialTheme.typography.bodyMedium.fontSize
//            )
//        )



        Spacer(Modifier.height(16.dp))

        // Search Button
        Button(
            onClick = { viewModel.searchDrugs(query)
                keyboardController?.hide()
                      },
            enabled = isQueryValid, //  Disable when query is empty
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(48.dp),
            shape = RoundedCornerShape(30),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF007AFF),
                disabledContainerColor = Color(0xFFB0B0B0) // Optional: gray out when disabled
            )
        ) {
            Text("Search", fontSize = 16.sp)
        }

        Spacer(Modifier.height(16.dp))

        // Search Results List
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            items(searchResults) { drug ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .height(60.dp)
                        .clickable {
                            val encodedName = URLEncoder.encode(drug.name, StandardCharsets.UTF_8.toString())
                            navController.navigate("detail/${drug.rxcui}/$encodedName")
                        },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White) // Set white background
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        // Medicine icon - replace R.drawable.medicine_icon with your drawable
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
                            tint = Color.Gray
                            ,
                            contentDescription = "Go to details"
                        )
                    }
                }
            }
        }
    }
}
