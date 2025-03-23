package com.example.moniepointassessment.feature.profile.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moniepointassessment.ui.theme.MoniepointAssessmentTheme

@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "Profile Screen", style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
@Preview
fun ProfileScreenPreview() {
    MoniepointAssessmentTheme {
        ProfileScreen()
    }
}