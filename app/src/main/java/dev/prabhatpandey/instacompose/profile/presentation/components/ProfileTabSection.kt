package dev.prabhatpandey.instacompose.profile.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import dev.prabhatpandey.instacompose.R
import dev.prabhatpandey.instacompose.profile.domain.models.PhotoModel
import dev.prabhatpandey.instacompose.profile.presentation.screens.GridViewGallery
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProfileTabSection(
    modifier: Modifier = Modifier,
    photos: List<PhotoModel>
) {
    val pagerState = rememberPagerState(0)

    Column(
        modifier = modifier
    ) {
        TabItems(pagerState = pagerState)
        TabPages(
            pagerState = pagerState,
            modifier = Modifier.weight(1F),
            photos = photos
        )
    }
}


@ExperimentalPagerApi
@Composable
fun TabItems(pagerState: PagerState) {
    val list = listOf(
        "Uploads" to R.drawable.ic_upload,
        "Exhibitions" to R.drawable.ic_exhi,
        "Revenue" to R.drawable.ic_revenue
    )
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = MaterialTheme.colorScheme.background,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                height = 4.dp,
                color = MaterialTheme.colorScheme.secondary,
            )
        },
        divider = {
            Divider(color = Color.Transparent)
        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                icon = {
                    Icon(
                        painter = painterResource(list[index].second), contentDescription = null,
                        tint = if (pagerState.currentPage == index)
                            MaterialTheme.colorScheme.onBackground
                        else
                            MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5F)
                    )

                },
                text = {
                    Text(
                        list[index].first,
                        color = if (pagerState.currentPage == index)
                            MaterialTheme.colorScheme.onBackground
                        else
                            MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5F),
                        style = MaterialTheme.typography.labelMedium,
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabPages(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    photos: List<PhotoModel>
) {
    HorizontalPager(
        state = pagerState,
        count = 3,
        modifier = modifier
    ) { page ->
        when (page) {
            0 -> {
                GridViewGallery(
                    photos = photos
                )
            }
            1 -> {
                Text(text = "page 2")
            }
            else -> {
                Text(text = "page 3")
            }

        }
    }
}
