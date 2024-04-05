package co.ninjavan.akira.designsystem.component.checkbox

import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.constraintlayout.compose.ConstraintLayout
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme

@Composable
fun Checkbox(
    toggleableState: ToggleableState,
    onCheckedChange: ((ToggleableState) -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String? = null,
    description: String? = null
) {
    val textColor = if (enabled) AkiraTheme.colors.gray2 else AkiraTheme.colors.gray7
    val checkboxColors = CheckboxDefaults.colors(
        checkedColor = AkiraTheme.colors.red3,
        uncheckedColor = AkiraTheme.colors.gray4,
        disabledCheckedColor = AkiraTheme.colors.gray7,
        disabledUncheckedColor = AkiraTheme.colors.gray7,
        disabledIndeterminateColor = AkiraTheme.colors.gray7,
    )

    ConstraintLayout {
        val (cb, lb, ds) = createRefs()
        TriStateCheckbox(
            state = toggleableState,
            onClick = {
                if (toggleableState == ToggleableState.On) {
                    onCheckedChange?.invoke(ToggleableState.Off)
                } else {
                    onCheckedChange?.invoke(ToggleableState.On)
                }
            },
            modifier = modifier.constrainAs(cb) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            },
            enabled = enabled,
            colors = checkboxColors
        )
        label?.let {
            Text(
                text = it,
                color = textColor,
                style = AkiraTheme.typography.body1,
                modifier = Modifier
                    .constrainAs(lb) {
                        top.linkTo(cb.top)
                        bottom.linkTo(cb.bottom)
                        start.linkTo(cb.end)
                    }

            )
        }
        description?.let {
            Text(
                text = it,
                color = textColor,
                style = AkiraTheme.typography.body2,
                modifier = Modifier
                    .constrainAs(ds) {
                        top.linkTo(lb.bottom)
                        start.linkTo(cb.end)
                    }

            )
        }
    }
}