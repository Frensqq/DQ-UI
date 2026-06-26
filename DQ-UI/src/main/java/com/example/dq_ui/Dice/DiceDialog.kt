package com.example.dq_ui.Dice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.dq_ui.Cards.CardEvents

@Composable
fun DiceResultDialog(
    result: Int,
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.45f))
            .clickable { onDismiss() },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {}
        ) {
            CardEvents(
                text = "Результат броска",
                nameEvent = "Выпало $result",
                textIventPreview = when (result) {
                    1 -> "⚀ 1"
                    2 -> "⚁ 2"
                    3 -> "⚂ 3"
                    4 -> "⚃ 4"
                    5 -> "⚄ 5"
                    6 -> "⚅ 6"
                    else -> "$result"
                }
            )
        }
    }
}