package co.ninjavan.akira.designsystem.compose.foundation

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.LocalContentColor
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

@Composable
fun AkiraTheme(
    typography: AkiraTypography = AkiraTheme.typography,
    shapes: AkiraShape = AkiraTheme.shapes,
    spacings: AkiraSpacing = AkiraTheme.spacings,
    colors: AkiraColor = AkiraTheme.colors,
    content: @Composable () -> Unit
) {

    val rippleIndication = rememberRipple()

    // creating a new object for colors to not mutate the initial colors set when updating the values
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalShapes provides shapes,
        LocalTypography provides typography,
        LocalIndication provides rippleIndication,
        LocalRippleTheme provides NoRippleTheme,
        LocalSpacing provides spacings
    ) {
        ProvideTextStyle(value = typography.body1, content = content)
    }
}

object AkiraTheme {

    val colors: AkiraColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AkiraTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: AkiraShape
        @ReadOnlyComposable
        @Composable
        get() = LocalShapes.current

    val spacings: AkiraSpacing
        @ReadOnlyComposable
        @Composable
        get() = LocalSpacing.current
}

@Immutable
private object MaterialRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = RippleTheme.defaultRippleColor(
        contentColor = LocalContentColor.current,
        lightTheme = !isSystemInDarkTheme()
    )

    @Composable
    override fun rippleAlpha() = RippleTheme.defaultRippleAlpha(
        contentColor = LocalContentColor.current,
        lightTheme = !isSystemInDarkTheme()
    )
}

@Immutable
 object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f,0.0f,0.0f,0.0f)
}
