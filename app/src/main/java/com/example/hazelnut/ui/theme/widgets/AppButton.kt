//package com.example.hazelnut.ui.theme.widgets
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.gestures.detectTapGestures
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScope
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.DrawModifier
//import androidx.compose.ui.draw.alpha
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.drawWithContent
//import androidx.compose.ui.graphics.BlendMode
//import androidx.compose.ui.graphics.Canvas
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.ColorFilter
//import androidx.compose.ui.graphics.Paint
//import androidx.compose.ui.graphics.drawscope.ContentDrawScope
//import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
//import androidx.compose.ui.graphics.nativeCanvas
//import androidx.compose.ui.graphics.toArgb
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.semantics.semantics
//import androidx.compose.ui.text.style.TextOverflow.Companion.Clip
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun AppButton(
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    isEnable: Boolean = true,
//    isLoading: Boolean = false,
//    content: @Composable RowScope.() -> Unit,
//) {
//    val buildButton: @Composable () -> Unit = {
//
//        fun isButtonEnable(): Boolean {
//            if (isLoading) return false
//            if (isEnable) return true
//            return true
//        }
//
//        Button(
//            colors = ButtonDefaults.buttonColors(
//                containerColor = MaterialTheme.colorScheme.primary,
//                contentColor = Color.White
//            ),
//            onClick = onClick,
//            enabled = isButtonEnable(),
//            modifier = modifier
//        ) {
//            Row(
//                modifier = Modifier.padding(vertical = 10.dp),
//            ) {
//                if (isLoading) {
//                    CircularProgressIndicator(
//                        color = Color.White,
//                        modifier = Modifier
//                            .width(19.dp)
//                            .height(19.dp)
//                            .padding(end = 5.dp, top = 1.dp),
//                        strokeWidth = 2.dp
//                    )
//                }
//                content()
//            }
//        }
//    }
//
//    if (isEnable) {
//        Row() {
//            buildButton()
//        }
//    } else {
//        DimmedOverlay(
//
//        ) {
//            buildButton()
//        }
//    }
//}
//
//@Composable
//fun DimmedOverlay(
//    onTap: () -> Unit = {},
//    content: @Composable () -> Unit
//) {
//    Box(
//        modifier = Modifier
//            .clickable { onTap() }
//            .clip(RoundedCornerShape(50.dp))
//            .drawWithContent {
//                drawContent()
//                drawRect(
//                    color = Color.Black.copy(alpha = 0.5f),
//                    blendMode = BlendMode.Darken
//                )
//            }
//            .pointerInput(Unit) { detectTapGestures { /* Do nothing */ } }
//    ) {
//        content()
//    }
//}
//@Preview
//@Composable
//fun ThreeTextComponent(text1: String = "safas", text2: String = "SFs", text3: String = "Sfs") {
//    Column {
//        Text(text = text1)
//        Row{
//            Text(text = text2)
//            Text(text = text3)
//        }
//    }
//}
