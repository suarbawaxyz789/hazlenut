package com.example.hazelnut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hazelnut.ui.theme.HazelnutTheme
import com.togitech.ccp.component.TogiCountryCodePicker

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HazelnutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login(
                        modifier = Modifier.padding(
                            top = 50.dp,
                            start = calculatePaddingByWidth(percentage = 2f),
                            end = calculatePaddingByWidth(
                                percentage = 2f
                            )
                        )
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(modifier: Modifier = Modifier) {
    val phoneNumber = rememberSaveable { mutableStateOf("") }
    val fullPhoneNumber = rememberSaveable { mutableStateOf("") }
    val onlyPhoneNumber = rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        Text(
            text = "Sign in to keep everything safe",
            style = MaterialTheme.typography.headlineSmall.copy(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(600),
            )
        )
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "To access your account, please enter your phone number below :",
            style = MaterialTheme.typography.labelMedium.copy(
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        TogiCountryCodePicker(
            text = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            bottomStyle = false,
            shape = RoundedCornerShape(5.dp),
            color = MaterialTheme.colorScheme.background,
        )
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = "Once you've entered your phone number, we will send you a verification code via SMS to confirm your identity. Please make sure the phone number you provide is correct.",
            style = MaterialTheme.typography.labelMedium.copy(
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            )
        )
        Spacer(modifier = Modifier.padding(top = 40.dp))
        MyButton(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Text(text = "Send Otp", style = MaterialTheme.typography.labelMedium)
        }
    }
}


@Composable
fun calculatePaddingByHeight(percentage: Float): Dp {
    val screenHeight =
        LocalDensity.current.run { androidx.compose.ui.platform.LocalContext.current.resources.displayMetrics.heightPixels }
    val padding = screenHeight * percentage / 100
    return padding.dp
}

@Composable
fun calculatePaddingByWidth(percentage: Float): Dp {
    val screenWidth =
        LocalDensity.current.run { androidx.compose.ui.platform.LocalContext.current.resources.displayMetrics.widthPixels }
    val padding = screenWidth * percentage / 100
    return padding.dp
}

@Composable
fun MyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),
        onClick = onClick,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            content = content
        )
    }
}