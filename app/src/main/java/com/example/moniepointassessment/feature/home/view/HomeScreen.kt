package com.example.moniepointassessment.feature.home.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moniepointassessment.components.AvailableVehiclesComponent
import com.example.moniepointassessment.components.MoveMateAppBar
import com.example.moniepointassessment.components.TrackingComponent
import com.example.moniepointassessment.ui.theme.AppGreyShade
import com.example.moniepointassessment.ui.theme.MoniepointAssessmentTheme

@Composable
fun HomeScreen(
) {
    HomeScreenContent()
}

@Composable
fun HomeScreenContent() {
    var isInSearchMode by remember { mutableStateOf(false) }
    MoniepointAssessmentTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                MoveMateAppBar(
                    onSearchModeChanged = { searchMode ->
                        isInSearchMode = searchMode
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
                AnimatedVisibility(
                    visible = !isInSearchMode,
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically(),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(AppGreyShade)
                            .padding(20.dp)
                            .verticalScroll(
                                state = rememberScrollState(),
                                reverseScrolling = false
                            )

                    ) {
                        Column {
                            TrackingComponent()
                            Spacer(modifier = Modifier.height(20.dp))
                            AvailableVehiclesComponent()

                        }
                    }
                }
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