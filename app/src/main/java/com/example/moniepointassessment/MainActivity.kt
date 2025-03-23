package com.example.moniepointassessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.moniepointassessment.components.BottomNavigationBar
import com.example.moniepointassessment.navigation.BottomNavGraph
import com.example.moniepointassessment.ui.theme.AppGreyShade
import com.example.moniepointassessment.ui.theme.MoniepointAssessmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoniepointAssessmentTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    containerColor = AppGreyShade,
                    bottomBar = { BottomNavigationBar(navController) },
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(
                                PaddingValues(bottom = innerPadding.calculateBottomPadding())
                            )
                    ){
                        BottomNavGraph(
                            navController
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoniepointAssessmentTheme {
        BottomNavGraph(rememberNavController(), modifier = Modifier.padding())
    }
}