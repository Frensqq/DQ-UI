package com.example.dq_ui.Inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dq_ui.UI.DiceQuestGradients.PurpleGlow
import com.example.dq_ui.UI.DiceQuestTheme

private val OtpWidth = 64.dp
private val OtpHeight = 72.dp
private val OtpCornerRadius = 10.dp

@Composable
fun OtpCell(
    value: String,
    onValueChange: (String) -> Unit,
    index: Int,
    focusRequester: FocusRequester,
    focusRequesters: List<FocusRequester>
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->

            if (newValue.length <= 1 && newValue.all { it.isDigit() }) {

                val oldValue = value

                onValueChange(newValue)

                when {
                    // переход вперед
                    oldValue.isEmpty() &&
                            newValue.isNotEmpty() &&
                            index < focusRequesters.lastIndex -> {
                        focusRequesters[index + 1].requestFocus()
                    }

                    // переход назад после удаления цифры
                    oldValue.isNotEmpty() &&
                            newValue.isEmpty() &&
                            index > 0 -> {
                        focusRequesters[index - 1].requestFocus()
                    }
                }
            }
        },
        singleLine = true,
        textStyle = DiceQuestTheme.typography.displayLarge.copy(textAlign = TextAlign.Center),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = DiceQuestTheme.colors.TextPrimary,
            unfocusedTextColor = DiceQuestTheme.colors.TextPrimary,
            focusedContainerColor = DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.2f),
            unfocusedContainerColor = DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.2f),
            focusedBorderColor = DiceQuestTheme.colors.PrimaryLight,
            unfocusedBorderColor = Color.Transparent,
            cursorColor = DiceQuestTheme.colors.PrimaryLight
        ),
        shape = RoundedCornerShape(OtpCornerRadius),
        modifier = Modifier
            .width(OtpWidth)
            .height(OtpHeight)
            .focusRequester(focusRequester)
            .onPreviewKeyEvent {
                if (
                    it.type == KeyEventType.KeyDown &&
                    it.key == Key.Backspace &&
                    value.isEmpty() &&
                    index > 0
                ) {
                    focusRequesters[index - 1].requestFocus()
                    true
                } else false
            }
    )
}

@Composable
fun OtpInput(
    count: Int = 4,
    onCodeChanged: (String) -> Unit = {}
) {
    val values = remember {
        mutableStateListOf(*Array(count) { "" })
    }

    val focusRequesters = remember {
        List(count) { FocusRequester() }
    }

    LaunchedEffect(Unit) {
        focusRequesters.first().requestFocus()
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        repeat(count) { index ->

            OtpCell(
                value = values[index],
                index = index,
                focusRequester = focusRequesters[index],
                focusRequesters = focusRequesters,
                onValueChange = {
                    values[index] = it
                    onCodeChanged(values.joinToString(""))
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOtpInput() {

    var code by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PurpleGlow)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OtpInput(
            count = 4,
            onCodeChanged = {
                code = it
            }
        )

        Text(
            text = "OTP: $code",
            color = DiceQuestTheme.colors.TextPrimary
        )
    }
}