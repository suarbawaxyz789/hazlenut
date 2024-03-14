package co.ninjavan.akira.designsystem.component.divider

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors

@Composable
fun DividerLight(modifier: Modifier = Modifier) {
    Divider(
        color = colors.gray7,
        modifier = modifier
    )
}

@Composable
fun DividerMedium(modifier: Modifier = Modifier) {
    Divider(
        color = colors.gray4,
        modifier = modifier
    )
}

@Composable
fun DividerDark(modifier: Modifier = Modifier) {
    Divider(
        color = colors.gray2,
        modifier = modifier
    )
}

@Composable
fun DividerRed(modifier: Modifier = Modifier) {
    Divider(
        color = colors.red4,
        modifier = modifier
    )
}

@Composable
fun DividerRedActive(modifier: Modifier = Modifier) {
    Divider(
        color = colors.red3,
        modifier = modifier
    )
}
