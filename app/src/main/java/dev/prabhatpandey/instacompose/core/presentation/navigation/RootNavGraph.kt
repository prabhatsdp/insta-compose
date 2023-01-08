package dev.prabhatpandey.instacompose.core.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.prabhatpandey.instacompose.profile.presentation.navigation.profileScreen


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = "root",
        startDestination = "profile"
    ) {
        profileScreen(navController)
    }
}