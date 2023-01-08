package dev.prabhatpandey.instacompose.profile.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import dev.prabhatpandey.instacompose.profile.presentation.screens.ProfileScreen

fun NavGraphBuilder.profileScreen(navController: NavHostController) {
    composable("profile") {
        ProfileScreen()
    }
}