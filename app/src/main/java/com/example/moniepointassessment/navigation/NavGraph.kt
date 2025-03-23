package com.example.moniepointassessment.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moniepointassessment.components.BottomBarScreen
import com.example.moniepointassessment.feature.calculate.view.CalculateScreen
import com.example.moniepointassessment.feature.home.view.HomeScreen
import com.example.moniepointassessment.feature.profile.view.ProfileScreen
import com.example.moniepointassessment.feature.shipment.view.ShipmentScreen

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController, startDestination = BottomBarScreen.Home.route,
    ) {
        composable(BottomBarScreen.Home.route) { HomeScreen() }
        composable(BottomBarScreen.Calculate.route) { CalculateScreen() }
        composable(BottomBarScreen.Shipment.route) { ShipmentScreen() }
        composable(BottomBarScreen.Profile.route) { ProfileScreen() }
    }
}