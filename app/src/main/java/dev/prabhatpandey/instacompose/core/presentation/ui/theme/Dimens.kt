import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

sealed class Dimens {
    object SP: Dimens() {
        val XXXLarge = 24.sp
        val Huge = 28.sp
        val XHuge = 32.sp
    }
    object DP : Dimens() {
        val Medium: Dp = 16.dp
        val Large: Dp = 20.dp
        val XLarge: Dp = 24.dp
        val XXLarge: Dp = 28.dp
        val XXXLarge: Dp = 32.dp
        val Small = 12.dp
        val XSmall = 8.dp
        val XXSmall = 4.dp
        val ButtonIconSize = 32.dp
        val TextFieldCornerSize = 8.dp
    }
}