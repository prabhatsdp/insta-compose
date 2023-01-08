package dev.prabhatpandey.instacompose.core.presentation.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import dev.prabhatpandey.instacompose.R


val FontFamily.Companion.Barlow: FontFamily
    get() = FontFamily(
        Font(R.font.barlow_thin, FontWeight.Thin),
        Font(R.font.barlow_light, FontWeight.Light),
        Font(R.font.barlow_regular),
        Font(R.font.barlow_medium, FontWeight.Medium),
        Font(R.font.barlow_bold, FontWeight.Bold),
        Font(R.font.barlow_semibold, FontWeight.SemiBold),
        Font(R.font.barlow_extrabold, FontWeight.ExtraBold),
        Font(R.font.barlow_black, FontWeight.Black)
    )