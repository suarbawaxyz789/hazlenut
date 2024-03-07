package co.ninjavan.akira.designsystem.compose.foundation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.hazelnut.R

@Immutable
data class AkiraTypography(

    val notosansFamily: FontFamily = FontFamily(
        Font(R.font.notosans_regular, FontWeight.Normal),
        Font(R.font.notosans_bold, FontWeight.Bold)
    ),
    val baseTextStyle: TextStyle = TextStyle(
        fontFamily = notosansFamily,
        letterSpacing = 0.sp
    ),
    val heading1: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 40.sp,
        lineHeight = 50.sp
    ),
    val heading1Bold: TextStyle = heading1.copy(
        fontWeight = FontWeight.Bold,
    ),
    val heading2: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        lineHeight = 40.sp
    ),
    val heading2Bold: TextStyle = heading2.copy(
        fontWeight = FontWeight.Bold,
    ),
    val heading3: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 27.sp,
        lineHeight = 40.sp
    ),
    val heading3Bold: TextStyle = heading3.copy(
        fontWeight = FontWeight.Bold,
    ),
    val heading4: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 30.sp
    ),
    val heading4Bold: TextStyle = heading4.copy(
        fontWeight = FontWeight.Bold,
    ),
    val heading5: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 30.sp
    ),
    val heading5Bold: TextStyle = heading5.copy(
        fontWeight = FontWeight.Bold,
    ),
    val heading6: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 25.sp
    ),
    val heading6Bold: TextStyle = heading6.copy(
        fontWeight = FontWeight.Bold,
    ),
    val body1: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 25.sp
    ),
    val body1Bold: TextStyle = body1.copy(
        fontWeight = FontWeight.Bold,
    ),
    val body2: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    val body2Bold: TextStyle = body2.copy(
        fontWeight = FontWeight.Bold,
    ),
    val body3: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 15.sp
    ),
    val body3Bold: TextStyle = body3.copy(
        fontWeight = FontWeight.Bold,
    ),
    val caption1: TextStyle = baseTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 15.sp
    ),
    val caption1Bold: TextStyle = caption1.copy(
        fontWeight = FontWeight.Bold,
    ),
)

internal val LocalTypography = staticCompositionLocalOf { AkiraTypography() }
