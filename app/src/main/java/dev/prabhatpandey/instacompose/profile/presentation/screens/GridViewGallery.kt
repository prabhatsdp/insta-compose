package dev.prabhatpandey.instacompose.profile.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import dev.prabhatpandey.instacompose.R
import dev.prabhatpandey.instacompose.profile.domain.models.PhotoModel

@Composable
fun GridViewGallery(
    photos: List<PhotoModel>
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            contentPadding = PaddingValues(8.dp),
            columns = GridCells.Fixed(2)
        ) {
            itemsIndexed(photos) { index, item ->
                GlideImage(
                    imageModel = { item.thumbUrl },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1F),
                    previewPlaceholder = R.drawable.ic_edit,
                    failure = {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                imageVector = Icons.Outlined.Warning,
                                contentDescription = null,
                            )
                        }
                    },
                    loading = {

                    }
                )
            }
        }
    }
}