package com.example.moniepointassessment.feature.home.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.moniepointassessment.components.MoveMateAppBar
import com.example.moniepointassessment.ui.theme.MoniepointAssessmentTheme

@Composable
fun HomeScreen(
) {
    HomeScreenContent()
}

@Composable
fun HomeScreenContent() {
    MoniepointAssessmentTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val verticalScroll = rememberScrollState()

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                MoveMateAppBar()
            }

        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    MoniepointAssessmentTheme {
        HomeScreenContent()
    }
}