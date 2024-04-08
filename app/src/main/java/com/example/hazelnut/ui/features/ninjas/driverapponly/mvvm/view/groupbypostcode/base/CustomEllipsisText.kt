package com.example.hazelnut.ui.features.ninjas.driverapponly.mvvm.view.groupbypostcode.base

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.TextUnit

/// original code taken from https://stackoverflow.com/questions/69083061/how-to-make-middle-ellipsis-in-text-with-jetpack-compose
@Composable
fun CustomEllipsisText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    softWrap: Boolean = true,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
    // set to 3 then result will be "NVSGCTTDR00000011173907...999", set to 5 then result will be "NVSGCTTDR000000111739...99999".
    lastCharLengthCount : Int =  3,
) {
    // some letters, like "r", will have less width when placed right before "."
    // adding a space to prevent such case
    val layoutText = remember(text) { "$text $ellipsisText" }
    val textLayoutResultState = remember(layoutText) {
        mutableStateOf<TextLayoutResult?>(null)
    }
    SubcomposeLayout(modifier) { constraints ->
        // result is ignored - we only need to fill our textLayoutResult
        subcompose("measure") {
            Text(
                text = layoutText,
                color = color,
                fontSize = fontSize,
                fontWeight = fontWeight,
                letterSpacing = letterSpacing,
                textDecoration = textDecoration,
                textAlign = textAlign,
                lineHeight = lineHeight,
                softWrap = softWrap,
                maxLines = 1,
                onTextLayout = { textLayoutResultState.value = it },
                style = style,
            )
        }.first().measure(Constraints())
        // to allow smart cast
        val textLayoutResult = textLayoutResultState.value
            ?: // shouldn't happen - onTextLayout is called before subcompose finishes
            return@SubcomposeLayout layout(0, 0) {}
        val placeable = subcompose("visible") {
            val finalText = remember(text, textLayoutResult, constraints.maxWidth) {
                if (text.isEmpty() || textLayoutResult.getBoundingBox(text.indices.last).right <= constraints.maxWidth) {
                    // text not including ellipsis fits on the first line.
                    return@remember text
                }

                val ellipsisWidth = layoutText.indices.toList()
                    .takeLast(ellipsisCharactersCount)
                    .let widthLet@{ indices ->
                        // fix this bug: https://issuetracker.google.com/issues/197146630
                        // in this case width is invalid
                        for (i in indices) {
                            val width = textLayoutResult.getBoundingBox(i).width
                            if (width > 0) {
                                return@widthLet width * ellipsisCharactersCount
                            }
                        }
                        // this should not happen, because
                        // this error occurs only for the last character in the string
                        throw IllegalStateException("all ellipsis chars have invalid width")
                    }
                val availableWidth = constraints.maxWidth - ellipsisWidth
                val startCounter = BoundCounter(text, textLayoutResult) { it }
                val endCounter = BoundCounter(text, textLayoutResult) { text.indices.last - it }

                while (availableWidth - startCounter.width - endCounter.width > 0) {
                    val possibleEndWidth = endCounter.widthWithNextChar()
                    if (
                        startCounter.width >= possibleEndWidth
                        && availableWidth - startCounter.width - possibleEndWidth >= 0 && endCounter.currentCharLength() < lastCharLengthCount
                    ) {
                        endCounter.addNextChar()
                    } else if (availableWidth - startCounter.widthWithNextChar() - endCounter.width >= 0) {
                        startCounter.addNextChar()
                    } else {
                        break
                    }
                }
                startCounter.string.trimEnd() + ellipsisText + endCounter.string.reversed()
                    .trimStart()
            }
            Text(
                text = finalText,
                color = color,
                fontSize = fontSize,
                fontWeight = fontWeight,
                letterSpacing = letterSpacing,
                textDecoration = textDecoration,
                textAlign = textAlign,
                lineHeight = lineHeight,
                softWrap = softWrap,
                onTextLayout = onTextLayout,
                style = style,
            )
        }[0].measure(constraints)
        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}


private const val ellipsisCharactersCount = 3
private const val ellipsisCharacter = '.'
private val ellipsisText =
    List(ellipsisCharactersCount) { ellipsisCharacter }.joinToString(separator = "")

private class BoundCounter(
    private val text: String,
    private val textLayoutResult: TextLayoutResult,
    private val charPosition: (Int) -> Int,
) {
    var string = ""
        private set
    var width = 0f
        private set

    private var _nextCharWidth: Float? = null
    private var invalidCharsCount = 0

    fun widthWithNextChar(): Float =
        width + nextCharWidth()

    private fun nextCharWidth(): Float =
        _nextCharWidth ?: run {
            var boundingBox: Rect
            // invalidCharsCount fixes this bug: https://issuetracker.google.com/issues/197146630
            invalidCharsCount--
            do {
                boundingBox = textLayoutResult
                    .getBoundingBox(charPosition(string.count() + ++invalidCharsCount))
            } while (boundingBox.right == 0f)
            _nextCharWidth = boundingBox.width
            boundingBox.width
        }

    fun addNextChar() {
        string += text[charPosition(string.count())]
        width += nextCharWidth()
        _nextCharWidth = null
    }

    fun currentCharLength() : Int{
        return string.length
    }
}