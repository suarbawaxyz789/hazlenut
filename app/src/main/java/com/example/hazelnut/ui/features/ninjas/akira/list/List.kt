package co.ninjavan.akira.designsystem.component.list

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissState
import androidx.compose.material.DismissValue
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.component.divider.DividerLight
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.colors
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.R
import com.example.hazelnut.ui.features.ninjas.akira.button.ButtonTextLink
import com.example.hazelnut.ui.features.ninjas.akira.button.IconButton
import kotlinx.coroutines.delay

@Composable
fun ListItem(
    text: String,
    index: Int,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    bgColor: Color = colors.white,
    rightText: String? = null,
    rightTextLink: String? = null,
    onRightTextLinkClick: (Int) -> Unit = {},
    leftIconRes: Int? = null,
    leftIconRotation: Float = 0f,
    rightIconRes: Int? = null,
    rightIconRotation: Float = 0f,
    notificationText: String? = null,
    selected: Boolean = false,
    enabled: Boolean = true,
    deletable: Boolean = false,
    onDelete: (Int) -> Unit = {},
    hasTopDivider: Boolean = true,
    hasBottomDivider: Boolean = true,
    leftImageRes: Int? = null,
    rightIconButtonRes: Int? = null,
    subtitleIconRef: Int? = null,
    subtitleText: String? = null,
) {
    if (deletable) {
        val context = LocalContext.current
        var show by remember { mutableStateOf(true) }
        val dismissState = rememberDismissState(
            confirmStateChange = {
                if (it == DismissValue.DismissedToStart) {
                    show = false
                    true
                } else false
            },
        )
        SwipeToDismiss(
            state = dismissState,
            modifier = Modifier.semantics { testTag = "swipe_to_dismiss" },
            directions = setOf(DismissDirection.EndToStart),
            dismissThresholds = { FractionalThreshold(0.4f) },
            background = {
                DismissBackground(dismissState)
            },
            dismissContent = {
                ListItemComponent(
                    text,
                    index,
                    onClick,
                    modifier,
                    bgColor,
                    rightText,
                    rightTextLink,
                    onRightTextLinkClick,
                    leftIconRes,
                    leftIconRotation,
                    rightIconRes,
                    rightIconRotation,
                    notificationText,
                    selected,
                    enabled,
                    hasTopDivider,
                    hasBottomDivider,
                    leftImageRes,
                    rightIconButtonRes,
                    subtitleIconRef,
                    subtitleText,
                )
            }
        )
        LaunchedEffect(show) {
            if (!show) {
                delay(200)
                onDelete(index)
                Toast.makeText(context, "Item removed $index", Toast.LENGTH_SHORT).show()
            }
        }
    } else {
        ListItemComponent(
            text,
            index,
            onClick,
            modifier,
            bgColor,
            rightText,
            rightTextLink,
            onRightTextLinkClick,
            leftIconRes,
            leftIconRotation,
            rightIconRes,
            rightIconRotation,
            notificationText,
            selected,
            enabled,
            hasTopDivider,
            hasBottomDivider,
            leftImageRes,
            rightIconButtonRes,
            subtitleIconRef,
            subtitleText,
        )
    }

}

@Composable
private fun ListItemComponent(
    text: String,
    index: Int,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    bgColor: Color = colors.white,
    rightText: String? = null,
    rightTextLink: String? = null,
    onRightTextLinkClick: (Int) -> Unit = {},
    leftIconRes: Int? = null,
    leftIconRotation: Float = 0f,
    rightIconRes: Int? = null,
    rightIconRotation: Float = 0f,
    notificationText: String? = null,
    selected: Boolean = false,
    enabled: Boolean = true,
    hasTopDivider: Boolean = true,
    hasBottomDivider: Boolean = true,
    leftImageRes: Int? = null,
    rightIconButtonRes: Int? = null,
    subtitleIconRef: Int? = null,
    subtitleText: String? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val colorSelector =
        if (!enabled) colors.gray4 else if (isPressed) colors.gray3 else colors.gray2
    Column(
        modifier = modifier.then(
            Modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = { if (enabled) onClick(index) }
                )
                .background(bgColor)
                .fillMaxWidth()
        )
    ) {
        if (hasTopDivider) {
            DividerLight()
        }
        Spacer(modifier = Modifier.size(spacings.spacingXxs))
        Row(verticalAlignment = Alignment.CenterVertically) {
            leftIconRes?.apply {
                Icon(
                    modifier = Modifier
                        .padding(
                            end = spacings.spacingXxs,
                        )
                        .size(spacings.spacingS)
                        .semantics { testTag = "left_icon" }
                        .rotate(leftIconRotation),
                    painter = painterResource(id = this),
                    tint = colorSelector,
                    contentDescription = null // decorative element
                )
            }
            leftImageRes?.apply {
                Image(
                    modifier = Modifier
                        .padding(
                            end = spacings.spacingXxs,
                        )
                        .size(spacings.spacingS)
                        .semantics { testTag = "left_img" }
                        .rotate(leftIconRotation),
                    painter = painterResource(id = this),
                    contentDescription = null // decorative element
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = text,
                    style = if (!selected) typography.body1 else typography.body1Bold,
                    color = colorSelector,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.semantics { testTag = "item_title_txt" }

                )
                if (subtitleText != null || subtitleIconRef != null) {
                    Spacer(modifier = Modifier.size(spacings.spacingXxxs))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        subtitleIconRef?.apply {
                            Icon(
                                modifier = Modifier
                                    .padding(start = spacings.spacingXxxs)
                                    .semantics { testTag = "item_subtitle_icon" }
                                    .size(spacings.spacingXs),
                                painter = painterResource(id = subtitleIconRef),
                                tint = colorSelector,
                                contentDescription = null // decorative element
                            )
                        }
                        subtitleText?.apply {
                            Text(
                                modifier = Modifier.padding(start = spacings.spacingXxxs)
                                    .semantics { testTag = "item_subtitle_txt" },
                                text = subtitleText,
                                style = typography.body2,
                                color = colorSelector,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
            if (selected) {
                Icon(
                    modifier = Modifier
                        .padding(
                            start = spacings.spacingL,
                        )
                        .size(spacings.spacingS)
                        .semantics { testTag = "item_selected_icon" }
                        .rotate(rightIconRotation),
                    painter = painterResource(id = R.drawable.icon_l_check),
                    tint = colors.red3,
                    contentDescription = null // decorative element
                )
            } else {
                rightText?.apply {
                    Text(
                        text = this, style = typography.body1, color = colorSelector,
                        modifier = Modifier
                            .padding(
                                start = spacings.spacingL,
                            )
                            .semantics { testTag = "right_txt" }
                    )
                }
                rightIconRes?.apply {
                    Icon(
                        modifier = Modifier
                            .padding(
                                start = spacings.spacingL,
                            )
                            .size(spacings.spacingS)
                            .semantics { testTag = "right_icon" }
                            .rotate(rightIconRotation),
                        painter = painterResource(id = this),
                        tint = colorSelector,
                        contentDescription = null // decorative element
                    )
                }
                rightTextLink?.apply {
                    ButtonTextLink(
                        text = this, onClick = { onRightTextLinkClick(index) },
                        enabled = enabled,
                        modifier = Modifier
                            .padding(
                                start = spacings.spacingL,
                            )
                            .semantics { testTag = "right_text_link" }
                    )
                }
                rightIconButtonRes?.apply {
                    IconButton(
                        modifier = Modifier.semantics { testTag = "right_icon_btn" },
                        iconRes = rightIconButtonRes,
                        onClick = { onRightTextLinkClick(index) },
                        isEnabled = enabled,
                        isPressed = isPressed
                    )
                }
            }
        }
        notificationText?.apply {
            Spacer(modifier = Modifier.size(spacings.spacingXxxs))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier
                        .padding(start = spacings.spacingXxxs)
                        .semantics { testTag = "notification_icon" }
                        .size(spacings.spacingXs),
                    painter = painterResource(id = R.drawable.expanable_arrow_up),
                    tint = colorSelector,
                    contentDescription = null // decorative element
                )
                Text(
                    modifier = Modifier.padding(start = spacings.spacingXxxs)
                        .semantics { testTag = "notification_txt" },
                    text = notificationText, style = typography.body2, color = colorSelector,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        Spacer(modifier = Modifier.size(spacings.spacingXxs))
        if (hasBottomDivider) {
            DividerLight()
        }
    }
}

@Composable
fun DismissBackground(dismissState: DismissState) {
    val color = when (dismissState.dismissDirection) {
        DismissDirection.EndToStart -> colors.red3
        DismissDirection.StartToEnd -> colors.red3
        null -> Color.Transparent
    }
    val direction = dismissState.dismissDirection
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(12.dp, 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier)
        if (direction == DismissDirection.EndToStart) Text(
            text = context.getString(R.string.delete),
            style = typography.body2, color = colors.white,
            modifier = Modifier.semantics { testTag = "delete_txt" }
        )

    }
}
