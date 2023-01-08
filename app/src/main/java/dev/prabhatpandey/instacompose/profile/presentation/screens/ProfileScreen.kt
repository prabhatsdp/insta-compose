package dev.prabhatpandey.instacompose.profile.presentation.screens

import Dimens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.prabhatpandey.instacompose.R
import dev.prabhatpandey.instacompose.core.presentation.ui.theme.InstaComposeTheme
import dev.prabhatpandey.instacompose.profile.presentation.components.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {

    val snackBarHostState = remember{SnackbarHostState()}
    val scope = rememberCoroutineScope()

    var isChecked by rememberSaveable {
        mutableStateOf(true)
    }

    var photos = viewModel.photos.collectAsState()

    LaunchedEffect(key1 = Unit) {
        launch {
            viewModel.snackBarError.collect { message ->
                scope.launch {
                    snackBarHostState.showSnackbar(
                        message = message
                    )
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState)}
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                ProfileAppBar()
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth(0.8F),
                ) {
                    CustomIconButton(
                        icon = painterResource(id = R.drawable.ic_upload),
                        text = stringResource(R.string.upload),
                        modifier = Modifier.width(72.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile_placeholder),
                        contentDescription = stringResource(R.string.profile_photo),
                        modifier = Modifier
                            .padding(horizontal = Dimens.DP.Large)
                            .size(127.dp)
                            .clip(CircleShape)
                    )
                    CustomIconButton(
                        icon = painterResource(id = R.drawable.ic_edit),
                        text = stringResource(R.string.edit),
                        modifier = Modifier.width(72.dp)
                    )
                }
                Text(
                    text = "John Doe",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 36.sp
                    ),
                    modifier = Modifier.padding(top = Dimens.DP.XSmall)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimens.DP.XLarge)
                ) {
                    Text(text = "My Dashboard")
                    Switch(
                        checked = isChecked,
                        onCheckedChange = { checked ->
                            isChecked = checked
                        }
                    )
                }
                Divider(
                    modifier = Modifier
                        .padding(
                            horizontal = Dimens.DP.Medium,
                            vertical = Dimens.DP.XSmall
                        )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimens.DP.Medium)
                ) {
                    CounterText(
                        count = "2.3k",
                        label = stringResource(R.string.followers),
                        modifier = Modifier.weight(1F)
                    )
                    CounterText(
                        count = "2.3k",
                        label = stringResource(R.string.artworks),
                        modifier = Modifier.weight(1F)
                    )
                    CounterText(
                        count = "2.3k",
                        label = stringResource(R.string.exhibitions),
                        modifier = Modifier.weight(1F)
                    )
                }
                Divider(
                    modifier = Modifier
                        .padding(
                            horizontal = Dimens.DP.Medium,
                            vertical = Dimens.DP.XSmall
                        )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth(0.75F)
                        .padding(
                            horizontal = Dimens.DP.Medium,
                            vertical = Dimens.DP.XXSmall
                        )
                ) {
                    CounterIcon(
                        icon = painterResource(id = R.drawable.ic_heart),
                        text = "120",
                        tint = Color.Red
                    )
                    CounterIcon(
                        icon = painterResource(id = R.drawable.ic_pointer),
                        text = "43k",
                        tint = Color(0xFF007DB2)
                    )
                    CounterIcon(
                        icon = painterResource(id = R.drawable.ic_share),
                        text = "2.3K",
                    )
                }
                ProfileTabSection(
                    modifier = Modifier.padding(top = Dimens.DP.XSmall),
                    photos = photos.value
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewProfileScreen() {
//    InstaComposeTheme {
//        ProfileScreen()
//    }
//}