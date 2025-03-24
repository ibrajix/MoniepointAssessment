package com.example.moniepointassessment.feature.calculate.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moniepointassessment.R
import com.example.moniepointassessment.components.BottomBarScreen
import com.example.moniepointassessment.ui.theme.AppGreen
import com.example.moniepointassessment.ui.theme.MoniepointAssessmentTheme
import com.example.moniepointassessment.ui.theme.White

@Composable
fun EstimateScreen(navController: NavController) {
    EstimateScreenContent(
        onClickBackHome = {
            navController.navigate(BottomBarScreen.Home.route) {
                popUpTo(BottomBarScreen.Home.route) { inclusive = true }
            }
        }
    )
}

@Composable
fun EstimateScreenContent(
    onClickBackHome: () -> Unit,
) {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(14.dp)
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(500)) + scaleIn(
                initialScale = 0.7f,
                animationSpec = tween(500)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    modifier = Modifier.scale(0.5F),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Box",
                    contentScale = ContentScale.Fit,
                )
                Image(
                    modifier = Modifier
                        .height(200.dp)
                        .width(100.dp),
                    painter = painterResource(R.drawable.box),
                    contentDescription = "Box",
                    contentScale = ContentScale.Fit,
                )
                Text(
                    "Total Estimated Amount",
                    fontSize = 22.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    "$1460",
                    color = AppGreen,
                    fontSize = 22.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    "The amount is estimated, this will vary\nif you change your location or weight",
                    color = Gray,
                    fontSize = 14.sp,
                    lineHeight = 16.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { onClickBackHome() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE67E22)),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Text(
                        text = "Back to home",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun EstimateScreenPreview() {
    MoniepointAssessmentTheme {
        EstimateScreenContent(onClickBackHome = {})
    }
}