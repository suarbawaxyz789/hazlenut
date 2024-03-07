package co.ninjavan.akira.designsystem.compose.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
@Immutable
data class AkiraColor(
    val red1: Color = Color(0xFF721A19),
    val red2: Color = Color(0xFF9A191F),
    val red3: Color = Color(0xFFC31424),
    val red4: Color = Color(0xFFFA002C),
    val red5: Color = Color(0xFFFFDEE4),
    val red6: Color = Color(0xFFFFF0F2),

    val gray1: Color = Color(0xFF2E2E2E),
    val gray2: Color = Color(0xFF4C4C4C),
    val gray3: Color = Color(0xFF8F8F8F),
    val gray4: Color = Color(0xFFB3B3B3),
    val gray5: Color = Color(0xFFCCCCCC),
    val gray6: Color = Color(0xFFD9D9D9),
    val gray7: Color = Color(0xFFE5E5E5),
    val gray8: Color = Color(0xFFF2F2F2),
    val gray9: Color = Color(0xFFF8F8F8),
    val white: Color = Color(0xFFFFFFFF),

    val green1: Color = Color(0xFF077D52),
    val green2: Color = Color(0xFF009961),
    val green3: Color = Color(0xFF00B271),
    val green4: Color = Color(0xFF02CA81),
    val green5: Color = Color(0xFFC7FFE9),
    val green6: Color = Color(0xFFF1FEF9),

    val blue1: Color = Color(0xFF0F5183),
    val blue2: Color = Color(0xFF065B9C),
    val blue3: Color = Color(0xFF1D74BB),
    val blue4: Color = Color(0xFF318FD6),
    val blue5: Color = Color(0xFFD1EBFF),
    val blue6: Color = Color(0xFFF1F8FE),

    val orange1: Color = Color(0xFFDD6210),
    val orange2: Color = Color(0xFFF06C00),
    val orange3: Color = Color(0xFFFF7700),
    val orange4: Color = Color(0xFFFF8E32),
    val orange5: Color = Color(0xFFFFE2C7),
    val orange6: Color = Color(0xFFFFF7F0),

    val purple1: Color = Color(0xFFF6F0FF),
    val purple2: Color = Color(0xFF4300A2),
    val purple3: Color = Color(0xFF5D0CCF),
    val purple4: Color = Color(0xFFA34DD2),
    val purple5: Color = Color(0xFFD2A4E2),
    val purple6: Color = Color(0xFFF6F0FF),

    val yellow1: Color = Color(0xFFA06800),
    val yellow2: Color = Color(0xFFC69100),
    val yellow3: Color = Color(0xFFF7B602),
    val yellow4: Color = Color(0xFFFFD22F),
    val yellow5: Color = Color(0xFFFFF3B2),
    val yellow6: Color = Color(0xFFFFFCDD)
)

internal val LocalColors = staticCompositionLocalOf { AkiraColor() }
