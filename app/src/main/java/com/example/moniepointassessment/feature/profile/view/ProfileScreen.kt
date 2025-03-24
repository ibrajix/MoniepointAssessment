package com.example.moniepointassessment.feature.profile.view

import android.content.Intent
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moniepointassessment.R
import com.example.moniepointassessment.ui.theme.AppGreyShade
import com.example.moniepointassessment.ui.theme.AppPurpleDark
import com.example.moniepointassessment.ui.theme.Black
import com.example.moniepointassessment.ui.theme.MoniepointAssessmentTheme
import com.example.moniepointassessment.ui.theme.White

@Composable
fun ProfileScreen() {
    ProfileScreenContent()
}

@Composable
fun ProfileScreenContent() {
    val scale = remember { Animatable(0.5f) }
    val alpha = remember { Animatable(0f) }

    val context = LocalContext.current

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
            .background(AppGreyShade)
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
                fontWeight = FontWeight.Bold,
                color = Black,
                modifier = Modifier.alpha(alpha.value)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Mobile Engineer",
                color = Black,
                modifier = Modifier.alpha(alpha.value)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "If you think I did well in this test, contact me—let's build! :)",
                color = Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .alpha(alpha.value)
                    .padding(horizontal = 28.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))

            val emailIntent = Intent(Intent.ACTION_SEND).apply {
                type = "message/rfc822"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("ibrajix@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Let's Build!")
                putExtra(
                    Intent.EXTRA_TEXT,
                    ""
                )
            }

            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppPurpleDark,
                    contentColor = White
                ),
                onClick = {
                    context.startActivity(Intent.createChooser(emailIntent, "Send Email"))
                }
            ) {
                Text(text = "Contact Me")
            }

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
