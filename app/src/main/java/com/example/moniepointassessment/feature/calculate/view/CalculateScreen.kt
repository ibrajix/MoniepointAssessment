package com.example.moniepointassessment.feature.calculate.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Backpack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.filled.DriveFolderUpload
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LineWeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.moniepointassessment.navigation.Screens
import com.example.moniepointassessment.ui.theme.AppBlueShade
import com.example.moniepointassessment.ui.theme.AppGreyShade
import com.example.moniepointassessment.ui.theme.AppPurple
import com.example.moniepointassessment.ui.theme.AppPurpleDark
import com.example.moniepointassessment.ui.theme.Black
import com.example.moniepointassessment.ui.theme.MoniepointAssessmentTheme
import com.example.moniepointassessment.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculateScreen(
    navController: NavController
) {
    CalculateScreenContent(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculateScreenContent(
    navController: NavController = rememberNavController()
) {

    val transition = remember { MutableTransitionState(false) }

    LaunchedEffect(Unit) {
        transition.targetState = true
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            containerColor = AppGreyShade,
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Calculate") },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = AppPurpleDark,
                        titleContentColor = White,
                        navigationIconContentColor = White
                    )
                )
            }
        ) { paddingValues ->
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 16.dp, vertical = paddingValues.calculateTopPadding())
            ) {

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Destination",
                    style = TextStyle(
                        color = AppBlueShade,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))


                AnimatedVisibility(
                    visibleState = transition,
                    enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 })
                ) {
                    Box(
                        modifier = Modifier
                            .wrapContentHeight()
                            .background(White)
                    ) {
                        Column {
                            var senderLocation by remember { mutableStateOf(TextFieldValue("")) }
                            var receiverLocation by remember { mutableStateOf(TextFieldValue("")) }
                            var weight by remember { mutableStateOf(TextFieldValue("")) }

                            InputField(
                                imageVector = Icons.Default.DriveFolderUpload,
                                placeholder = "Sender location",
                                value = senderLocation,
                                onValueChange = { senderLocation = it }
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            InputField(
                                imageVector = Icons.Default.CloudDownload,
                                placeholder = "Receiver location",
                                value = receiverLocation,
                                onValueChange = { receiverLocation = it }
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            InputField(
                                imageVector = Icons.Default.LineWeight,
                                placeholder = "Approx weight",
                                value = weight,
                                onValueChange = { weight = it }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Packaging",
                    style = TextStyle(
                        color = AppBlueShade,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = "What are you sending?",
                    fontSize = 16.sp,
                    color = Gray,
                    modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
                )

                BoxSelectionField()

                Spacer(modifier = Modifier.height(32.dp))

                AnimatedVisibility(
                    visibleState = transition,
                    enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 })
                ) {
                    Text(
                        text = "Categories",
                        style = TextStyle(
                            color = AppBlueShade,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                CategoryChips()

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                    onClick = {
                        navController.navigate(Screens.estimateScreen)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE67E22)),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Text(
                        text = "Calculate",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Composable
fun InputField(
    imageVector: ImageVector,
    placeholder: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(AppGreyShade)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            imageVector = imageVector,
            colorFilter = ColorFilter.tint(color = Gray),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))
        VerticalDivider(
            modifier = Modifier
                .width(1.dp)
                .height(24.dp)
                .background(Gray)
        )

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = Gray,
                    fontSize = 16.sp,
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = AppPurple,
            ),
            textStyle = TextStyle(color = Black),
            singleLine = true
        )
    }
}

@Composable
fun BoxSelectionField() {
    var expanded by remember { mutableStateOf(false) }
    var selectedPackage by remember { mutableStateOf("Box") }
    val packages = listOf("Box", "Envelope", "Pallet", "Crate", "Tube")

    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .clickable { expanded = true }
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Default.Backpack,
                contentDescription = null,
                colorFilter = ColorFilter.tint(AppBlueShade),
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))
            VerticalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .height(24.dp)
                    .background(Color.Gray)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = selectedPackage,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = AppBlueShade,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Expand",
                tint = Color.Gray
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .background(Color.White)
        ) {
            packages.forEach { package_ ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = package_,
                            color = Color.Black
                        )
                    },
                    onClick = {
                        selectedPackage = package_
                        expanded = false
                    }
                )
            }
        }

    }
}

@Composable
fun CategoryChips() {
    val categories =
        listOf("Document", "Glass", "Liquid", "Food", "Electronic", "Product", "Others")

    var selectedCategories by remember { mutableStateOf(setOf<String>()) }

    Column {
        Text(
            text = "What are you sending?",
            fontSize = 16.sp,
            color = Gray,
            modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
        )

        categories.chunked(4).forEachIndexed { rowIndex, rowCategories ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                rowCategories.forEachIndexed { index, category ->
                    val delay = (index + rowIndex * 4) * 100 // Staggered delay

                    AnimatedVisibility(
                        visible = true,
                        enter = slideInHorizontally(
                            initialOffsetX = { it }, // Moves from right
                            animationSpec = tween(durationMillis = 500, delayMillis = delay)
                        ) + fadeIn(),
                        modifier = Modifier.wrapContentWidth()
                    ) {
                        CategoryChip(
                            text = category,
                            isSelected = selectedCategories.contains(category),
                            onSelected = {
                                selectedCategories = if (selectedCategories.contains(category)) {
                                    selectedCategories - category
                                } else {
                                    selectedCategories + category
                                }
                            },
                            modifier = Modifier.wrapContentWidth()
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryChip(
    text: String,
    isSelected: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .height(40.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onSelected
            ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        color = if (isSelected) AppBlueShade else Color.White
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Selected",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(2.dp))
            }

            Text(
                text = text,
                fontSize = 14.sp,
                color = if (isSelected) Color.White else AppBlueShade,
                maxLines = 1
            )
        }
    }
}

@Composable
@Preview
fun CalculateScreenPreview() {
    MoniepointAssessmentTheme {
        CalculateScreen(navController = rememberNavController())
    }
}