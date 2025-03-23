package com.example.moniepointassessment.feature.calculate.view

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
fun CalculateScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Calculate Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
@Preview
fun CalculateScreenPreview() {
    MoniepointAssessmentTheme {
       CalculateScreen()
    }
}