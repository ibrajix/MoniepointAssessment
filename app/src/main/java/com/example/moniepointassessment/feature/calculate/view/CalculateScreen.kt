package com.example.moniepointassessment.feature.calculate.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Backpack
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.filled.DriveFolderUpload
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LineWeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moniepointassessment.ui.theme.AppBlueShade
import com.example.moniepointassessment.ui.theme.AppGreyShade
import com.example.moniepointassessment.ui.theme.MoniepointAssessmentTheme
import com.example.moniepointassessment.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculateScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Calculate") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF673AB7),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        CalculateScreenContent(Modifier.padding(paddingValues))
    }
}

@Composable
fun CalculateScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Destination",
            style = TextStyle(
                color = AppBlueShade,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(14.dp))

        Box(
            modifier = Modifier
                .background(White)
                .padding(12.dp),
        ) {
            Column {
                InputField(
                    imageVector = Icons.Default.DriveFolderUpload,
                    placeholder = "Sender location"
                )

                Spacer(modifier = Modifier.height(12.dp))

                InputField(
                    imageVector = Icons.Default.CloudDownload,
                    placeholder = "Receiver location"
                )

                Spacer(modifier = Modifier.height(12.dp))

                InputField(
                    imageVector = Icons.Default.LineWeight,
                    placeholder = "Approx weight"
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Packaging",
            style = TextStyle(
                color = AppBlueShade,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = "What are you sending?",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
        )

        BoxSelectionField()

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Categories",
            style = TextStyle(
                color = AppBlueShade,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = "What are you sending?",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
        )

        CategoryChips()

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE67E22)),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                text = "Calculate",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}


@Composable
fun InputField(imageVector: ImageVector, placeholder: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(AppGreyShade)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = imageVector,
            colorFilter = ColorFilter.tint(color = AppBlueShade),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))
        VerticalDivider(
            modifier = Modifier
                .width(1.dp)
                .height(24.dp)
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = placeholder,
            color = Color.Gray,
            fontSize = 16.sp,
        )
    }
}

@Composable
fun BoxSelectionField() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = Icons.Default.Backpack,
            contentDescription = null,
            colorFilter = ColorFilter.tint(AppBlueShade),
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))
        VerticalDivider(
            modifier = Modifier
                .width(1.dp)
                .height(24.dp)
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Box",
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = AppBlueShade,
            modifier = Modifier.weight(1f)
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Expand",
            tint = Color.Gray
        )
    }
}

@Composable
fun CategoryChips() {
    val categories =
        listOf("Documents", "Glass", "Liquid", "Food", "Electronic", "Product", "Others")

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        categories.take(4).forEach { category ->
            CategoryChip(text = category, modifier = Modifier.weight(1f))
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        categories.drop(4).forEach { category ->
            CategoryChip(text = category, modifier = Modifier.weight(1f))
        }

        // Empty weight to balance the row (since we have 3 items in the second row but 4 in the first)
        Spacer(modifier = Modifier.weight(1f))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryChip(text: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.height(35.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.LightGray)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontSize = 14.sp,
                color = AppBlueShade,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 2.dp)
            )
        }
    }
}


@Composable
@Preview
fun CalculateScreenPreview() {
    MoniepointAssessmentTheme {
        CalculateScreen(navController = rememberNavController())
    }
}