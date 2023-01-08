package dev.prabhatpandey.instacompose.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.prabhatpandey.instacompose.core.presentation.navigation.RootNavGraph
import dev.prabhatpandey.instacompose.core.presentation.ui.theme.InstaComposeTheme
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstaComposeTheme {
                RootScreen()
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun RootScreen() {
    val navController = rememberNavController()
    var isBackButtonVisible by rememberSaveable {
        mutableStateOf(false)
    }

    var context = LocalContext.current

    Scaffold {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            RootNavGraph(navController = navController)
        }
    }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collectLatest {
            isBackButtonVisible = navController.previousBackStackEntry != null
        }
    }
}
