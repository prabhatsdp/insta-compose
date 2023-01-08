package dev.prabhatpandey.instacompose.profile.presentation.components

import Dimens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.prabhatpandey.instacompose.R
import dev.prabhatpandey.instacompose.core.presentation.ui.theme.InstaComposeTheme

@Composable
fun ProfileAppBar(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = Dimens.DP.Medium)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_app_logo),
                contentDescription = stringResource(R.string.agc),
                modifier = Modifier
                    .padding(start = Dimens.DP.Medium)
                    .height(33.dp)
                    .width(82.dp)
            )
            Spacer(modifier = Modifier.weight(1F))
            Surface(
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .padding(horizontal = Dimens.DP.XXSmall)
                    .size(33.dp)
            ) {
                Image(
                    painter = rememberVectorPainter(image = Icons.Outlined.Person),
                    contentDescription = stringResource(R.string.profile_photo),
                    modifier = Modifier.padding(Dimens.DP.XXSmall),
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(horizontal = Dimens.DP.XXSmall)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = stringResource(R.string.add)
                )
            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(horizontal = Dimens.DP.XXSmall)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu),
                    contentDescription = stringResource(R.string.add)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileAppBar() {
    InstaComposeTheme {
        ProfileAppBar()
    }
}