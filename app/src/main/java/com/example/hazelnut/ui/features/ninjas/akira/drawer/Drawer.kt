package co.ninjavan.akira.designsystem.component.drawer

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.spacings
import co.ninjavan.akira.designsystem.compose.foundation.AkiraTheme.typography
import com.example.hazelnut.R
import kotlinx.coroutines.launch

class Drawer @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    var headerText by mutableStateOf("")
    @OptIn(ExperimentalMaterialApi::class)
    var onStateChanged by mutableStateOf<(ModalBottomSheetValue) -> Unit>({})
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    override fun Content() {
        Drawer(headerText = headerText, onStateChanged = onStateChanged, content = {  })
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Drawer(
    headerText: String,
    showState: ModalBottomSheetValue = ModalBottomSheetValue.Hidden,
    // Must be implemented to link the state to client
    onStateChanged: (ModalBottomSheetValue) -> Unit,
    skipHalfExpanded: Boolean = false,
    forceFullScreen: Boolean = false,
    disableGestureDismiss: Boolean = false,
    hideCloseButton: Boolean = false,
    content: @Composable() () -> Unit,
    customHeight : Dp? = null,
) {

    val sheetState = remember {
        ModalBottomSheetState(
            initialValue = showState,
            isSkipHalfExpanded = skipHalfExpanded,
            confirmStateChange = {
                if (disableGestureDismiss && it == ModalBottomSheetValue.Hidden) {
                    return@ModalBottomSheetState false
                }
                onStateChanged(it)
                true
            }
        )
    }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(showState) {
        coroutineScope.launch {
            when (showState) {
                ModalBottomSheetValue.Hidden -> sheetState.hide()
                ModalBottomSheetValue.Expanded -> sheetState.show()
                ModalBottomSheetValue.HalfExpanded -> sheetState.show()
            }
        }
    }

    ModalBottomSheetLayout(
        sheetBackgroundColor = Color.Transparent,
        sheetElevation = 0.dp,
        sheetContent = {
            Column {
                Spacer(modifier = Modifier
                    .height(spacings.spacingXxl)
                    .width(0.dp))
                Column(
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colors.surface, shape = RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp
                            )
                        ).let {
                            if (forceFullScreen) it.fillMaxHeight() else if(customHeight != null) it.height(customHeight) else it
                        }
                ) {
                    Row(modifier = Modifier.padding(top = spacings.spacingL)) {
                        Text(
                            modifier = Modifier
                                .padding(start = spacings.spacingS),
                            text = headerText,
                            style = typography.heading6Bold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        if (!hideCloseButton) {
                            Icon(
                                modifier = Modifier
                                    .clickable {
                                        coroutineScope.launch {
                                            sheetState.hide()
                                            onStateChanged(ModalBottomSheetValue.Hidden)
                                        }
                                    }
                                    .size(20.dp),
                                painter = painterResource(id = R.drawable.icon_m_times),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.size(width = spacings.spacingS, height = 0.dp))
                        }
                    }
                    content()
                }
            }
        },
        sheetState = sheetState
    ) {
    }
}
