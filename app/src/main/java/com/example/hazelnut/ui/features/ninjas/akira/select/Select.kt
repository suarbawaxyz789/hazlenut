package co.ninjavan.akira.designsystem.component.select

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.res.painterResource
import co.ninjavan.akira.designsystem.component.divider.DividerMedium
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.R

class Select @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    var enabledValue by mutableStateOf(true)
    var text by mutableStateOf("")
    var labelText by mutableStateOf("")
    var optionalText by mutableStateOf("")
    var filled by mutableStateOf(true)
    private var onClick: () -> Unit = {}

    @Composable
    override fun Content() {
        Select(
            text = text,
            labelText = labelText,
            onClick = onClick,
            optionalText = optionalText,
            filled = filled,
            enabled = enabledValue,
        )
    }

    fun setOnClick(onClick: () -> Unit) {
        this.onClick = onClick
    }

    fun initialize(
        text: String,
        labelText: String,
        onClick: () -> Unit,
        optionalText: String = "",
        filled: Boolean = false,
        enabled: Boolean = true,
    ) {
        this.text = text
        this.labelText = labelText
        this.optionalText = optionalText
        this.enabledValue = enabled
        this.filled = filled
        this.onClick = onClick
    }
}


@Composable
fun Select(
    text: String,
    labelText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    optionalText: String = "",
    filled: Boolean = false,
    enabled: Boolean = true,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val colorSelector =
        if (!enabled) colors.gray4 else colors.gray2
    val labelColorSelector =
        if (!enabled) colors.gray4 else colors.gray3
    val textColorSelector =
        if (!enabled) colors.gray4 else if (filled) colors.gray2 else colors.gray3
    val clickModifier = if (enabled) modifier.then(
        Modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .fillMaxWidth()
    ) else Modifier.fillMaxWidth()
    Column(
        modifier = clickModifier
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = labelText, style = typography.body2, color = labelColorSelector,
                modifier = Modifier
                    .padding(bottom = spacings.spacingXxs)
                    .weight(1f),
            )
            Text(
                text = optionalText, style = typography.body2, color = colorSelector,
                modifier = Modifier.padding(bottom = spacings.spacingXxs),
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = text, style = typography.body1, color = textColorSelector,
                modifier = Modifier.weight(1f)
            )
            Icon(
                modifier = Modifier
                    .padding(start = spacings.spacingXxs)
                    .size(spacings.spacingXs)
                    .rotate(90f),
                painter = painterResource(id = R.drawable.angle_right),
                tint = colorSelector,
                contentDescription = null // decorative element
            )
        }
        DividerMedium()
    }
}
