package com.example.moniepointassessment.feature.profile.view

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moniepointassessment.R
import com.example.moniepointassessment.ui.theme.MoniepointAssessmentTheme

@Composable
fun ProfileScreen() {
    ProfileScreenContent()
}

@Composable
fun ProfileScreenContent() {
    val scale = remember { Animatable(0.5f) }
    val alpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 800, easing = EaseOutBounce)
        )
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 500, delayMillis = 300)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.box),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .scale(scale.value)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Inuwa Ibrahim",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.alpha(alpha.value)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Mobile Engineer",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                modifier = Modifier.alpha(alpha.value)
            )

            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileScreenPreview() {
    MoniepointAssessmentTheme {
        ProfileScreen()
    }
}
