package com.example.moniepointassessment.feature.shipment.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moniepointassessment.R
import com.example.moniepointassessment.ui.theme.AppOrange
import com.example.moniepointassessment.ui.theme.AppPurpleDark
import com.example.moniepointassessment.ui.theme.MoniepointAssessmentTheme

@Composable
fun ShipmentScreen() {
    ShipmentScreenContent()
}

@Composable
fun ShipmentScreenContent() {
    var selectedTab by remember { mutableStateOf("All") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsCustomTopHeight(WindowInsets.statusBars)
                .background(AppPurpleDark)
        )

        ShipmentTopAppBar()

        TabFilters(selectedTab) { tab -> selectedTab = tab }

        ShipmentsSection()
    }
}

@Composable
fun Modifier.windowInsetsCustomTopHeight(insets: WindowInsets): Modifier {
    val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    return this.height(statusBarHeight)
}

@Composable
fun ShipmentTopAppBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppPurpleDark)
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = "Shipment history",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun TabFilters(selectedTab: String, onTabSelected: (String) -> Unit) {

    val tabs = listOf("All", "Completed", "In progress", "Pending order", "Cancelled")
    var tabPositions by remember { mutableStateOf(mapOf<String, Pair<Float, Int>>()) }
    var selectedTabOffset by remember { mutableStateOf(0.dp) }
    var selectedTabWidth by remember { mutableStateOf(60.dp) }
    val density = LocalDensity.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppPurpleDark)
    ) {
        var parentOffsetX by remember { mutableStateOf(0f) }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    parentOffsetX = coordinates.positionInWindow().x
                }
        ) {
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(top = 8.dp, bottom = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(modifier = Modifier.width(16.dp))

                tabs.forEach { tab ->
                    Box(
                        modifier = Modifier.onGloballyPositioned { coordinates ->
                            val positionX = coordinates.positionInWindow().x - parentOffsetX
                            val width = coordinates.size.width
                            tabPositions = tabPositions.toMutableMap().apply {
                                put(tab, positionX to width)
                            }
                            if (tab == selectedTab) {
                                selectedTabOffset = with(density) { positionX.toDp() }
                                selectedTabWidth = with(density) { width.toDp() }
                            }
                        }
                    ) {
                        ShipmentTabItem(
                            text = tab,
                            count = when (tab) {
                                "All" -> 12
                                "Completed" -> 5
                                "In progress" -> 3
                                "Pending order" -> 4
                                else -> null
                            },
                            isSelected = selectedTab == tab,
                            onClick = { onTabSelected(tab) }
                        )
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
        ) {
            Box(
                modifier = Modifier
                    .offset(x = selectedTabOffset)
                    .width(selectedTabWidth)
                    .height(4.dp)
                    .background(AppOrange)
            )
        }
    }
}

@Composable
fun ShipmentTabItem(
    text: String,
    count: Int? = null,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color.White.copy(alpha = 0.7f),
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            fontSize = 16.sp
        )

        if (count != null) {
            Spacer(modifier = Modifier.width(4.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(if (isSelected) AppOrange else Color.White.copy(alpha = 0.3f))
                    .padding(2.dp)
            ) {
                Text(
                    text = count.toString(),
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun ShipmentsSection() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Shipments",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ShipmentItem(
            status = "in-progress",
            statusColor = Color(0xFF4CAF50),
            price = "$1400 USD",
            date = "Sep 20,2023"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ShipmentItem(
            status = "pending",
            statusColor = Color(0xFFE5A84C),
            price = "$650 USD",
            date = "Sep 20,2023"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ShipmentItem(
            status = "pending",
            statusColor = Color(0xFFE5A84C),
            price = "$650 USD",
            date = "Sep 20,2023"
        )
    }
}

@Composable
fun ShipmentItem(
    status: String,
    statusColor: Color,
    price: String,
    date: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardColors(
            containerColor = Color(0xFFF9FCFA),
            contentColor = Color.Black,
            disabledContainerColor = Color(0xFFF9FCFA),
            disabledContentColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.scan),
                    contentDescription = status,
                    tint = statusColor,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = status,
                    color = statusColor,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Arriving today!",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Your delivery, #NEJ20089934122231",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "from Atlanta, is arriving today!",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = price,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF6A3DE8)
                        )

                        Text(
                            text = " • $date",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .background(Color(0xFFEEEEEE))
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "📦",
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}


@Composable
@Preview
fun ShipmentScreenPreview() {
    MoniepointAssessmentTheme {
        ShipmentScreenContent()
    }
}