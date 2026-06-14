package com.example.dq_ui.Button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dq_ui.UI.DiceQuestGradients.PurpleGlow
import com.example.dq_ui.UI.DiceQuestTheme

@Composable
fun ButtonSmall(onClick: () -> Unit, text: String, enabled: Boolean = true, type: Boolean = true) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(45.dp)
            .width(120.dp)
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(17.dp),
                clip = false
            ),
        enabled = enabled,
        shape = RoundedCornerShape(17.dp),
        colors = if (type) {
            ButtonDefaults.buttonColors(
                containerColor = DiceQuestTheme.colors.Error,
                contentColor = DiceQuestTheme.colors.TextPrimary,
                disabledContainerColor = DiceQuestTheme.colors.Error,
                disabledContentColor = DiceQuestTheme.colors.TextPrimary.copy(alpha = 0.5f),
            )
        } else {
            ButtonDefaults.buttonColors(
                containerColor = DiceQuestTheme.colors.Success,
                contentColor = DiceQuestTheme.colors.TextPrimary,
                disabledContainerColor = DiceQuestTheme.colors.Success,
                disabledContentColor = DiceQuestTheme.colors.TextPrimary.copy(alpha = 0.5f),
            )
        },
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 6.dp,
            pressedElevation = 2.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text, style = DiceQuestTheme.typography.titleMedium)
    }
}

@Preview
@Composable
fun TestButtonSmall(){
    Column(modifier = Modifier.fillMaxSize()
        .background(PurpleGlow).padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)

    ) {

        Spacer(modifier = Modifier.size(50.dp))

        ButtonSmall({}, "Выйти",true, true)

        ButtonSmall({},"Выйти", false, true)

        ButtonSmall({},"Пауза", true, false)

        ButtonSmall({},"Пауза", false, false)


    }
}
