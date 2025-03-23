package com.example.moniepointassessment.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moniepointassessment.R
import com.example.moniepointassessment.ui.theme.AppBlueShade
import com.example.moniepointassessment.ui.theme.Black
import com.example.moniepointassessment.ui.theme.MoniepointAssessmentTheme

@Composable
fun AvailableVehiclesComponent() {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                "Available vehicles",
                style = TextStyle(
                    color = AppBlueShade,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    VehicleOptionCard(
                        title = "Ocean freight",
                        subtitle = "International",
                        imageRes = R.drawable.ship
                    )
                }

                item {
                    VehicleOptionCard(
                        title = "Cargo freight",
                        subtitle = "Reliable",
                        imageRes = R.drawable.ship
                    )
                }

                item {
                    VehicleOptionCard(
                        title = "Air freight",
                        subtitle = "International",
                        imageRes = R.drawable.ship
                    )
                }
            }
        }
    }
}

@Composable
fun VehicleOptionCard(
    title: String,
    subtitle: String,
    imageRes: Int,
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(240.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // Title and subtitle in top-start corner with proper padding
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
                    .align(Alignment.TopStart)
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    color = Black,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = subtitle,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            // Image positioned closer to the text and larger in size
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = 30.dp, y = 20.dp) // Adjusted to reduce space between text and image
            )
        }
    }
}

@Composable
@Preview
fun AvailableVehiclesComponentPreview() {
    MoniepointAssessmentTheme {
        AvailableVehiclesComponent()
    }
}