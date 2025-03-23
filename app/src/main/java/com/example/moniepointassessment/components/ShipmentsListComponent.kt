package com.example.moniepointassessment.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moniepointassessment.R
import com.example.moniepointassessment.ui.theme.AppPurpleDark
import com.example.moniepointassessment.ui.theme.White

@Composable
fun ShipmentListComponent(searchQuery: String) {
    val shipments = remember {
        listOf(
            ShipmentItem(
                id = "NE4385734085790",
                title = "Macbook pro M2",
                origin = "Paris",
                destination = "Morocco"
            ),
            ShipmentItem(
                id = "NEJ2008993412223",
                title = "Summer linen jacket",
                origin = "Barcelona",
                destination = "Paris"
            ),
            ShipmentItem(
                id = "NEJ3587026497865",
                title = "Tapered-fit jeans AW",
                origin = "Colombia",
                destination = "Paris"
            ),
            ShipmentItem(
                id = "NEJ3587026497865",
                title = "Slim fit jeans AW",
                origin = "Bogota",
                destination = "Dhaka"
            ),
            ShipmentItem(
                id = "NEJ2348157075496",
                title = "Office setup desk",
                origin = "France",
                destination = "German"
            )
        )
    }


    val filteredShipments = remember(shipments, searchQuery) {
        if (searchQuery.isEmpty()) {
            shipments
        } else {
            shipments.filter {
                it.title.contains(searchQuery, ignoreCase = true) ||
                        it.id.contains(searchQuery, ignoreCase = true) ||
                        it.origin.contains(searchQuery, ignoreCase = true) ||
                        it.destination.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            items(filteredShipments.size) { index ->
                val shipment = filteredShipments[index]
                ShipmentItem(shipment = shipment)
                if (shipment != filteredShipments.last()) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        thickness = 2.dp, color = Color.LightGray.copy(alpha = 0.5f)
                    )
                }
            }
        }
    }
}

@Composable
fun ShipmentItem(shipment: ShipmentItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {}
            .padding(vertical = 12.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(AppPurpleDark.copy(alpha = 0.8f))
                .padding(12.dp)
        ) {

            Image(
                painter = painterResource(R.drawable.item_packages),
                contentDescription = "Package Icon",
                modifier = Modifier
                    .align(Alignment.Center),
                colorFilter = ColorFilter.tint(color = White)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = shipment.title,
                style = MaterialTheme.typography.titleMedium,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "#${shipment.id} • ${shipment.origin} → ${shipment.destination}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}

data class ShipmentItem(
    val id: String,
    val title: String,
    val origin: String,
    val destination: String
)

@Composable
@Preview
fun ShipmentListComponentPreview() {
    ShipmentListComponent(searchQuery = "")
}