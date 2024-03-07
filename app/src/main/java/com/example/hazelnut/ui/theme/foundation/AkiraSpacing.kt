package co.ninjavan.akira.designsystem.compose.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AkiraSpacing(
    val spacingZero: Dp = 0.dp,
    val spacingXxxs: Dp = 5.dp,
    val spacingXxs: Dp = 10.dp,
    val spacingXs: Dp = 15.dp,
    val spacingS: Dp = 20.dp,
    val spacingM: Dp = 25.dp,
    val spacingL: Dp = 30.dp,
    val spacingXl: Dp = 40.dp,
    val spacingXxl: Dp = 60.dp,
    val spacingXxxl: Dp = 75.dp,
)

val LocalSpacing = staticCompositionLocalOf { AkiraSpacing() }
