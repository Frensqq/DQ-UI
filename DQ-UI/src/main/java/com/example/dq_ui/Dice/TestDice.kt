package com.example.dq_ui.Dice

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dq_ui.Cards.CardEvents
import com.example.dq_ui.UI.DiceQuestTheme

@Composable
fun DiceScreen() {
    // Состояние для хранения результата броска
    var diceResult by remember { mutableStateOf<String?>(null) }
    var showResult by remember { mutableStateOf(false) }

    fun rollDice() {
        val value = (1..6).random()
        diceResult = value.toString()  // Преобразуем число в строку
        showResult = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (showResult && diceResult != null) {
            // Показываем CardEvents с числом в виде строки
            CardEvents(
                nameEvent = "Результат броска",
                descriptionEvent = "Выпало число $diceResult",
                text = "Бросок",
                textIventPreview = diceResult  // Передаем число как строку
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    showResult = false  // Скрываем результат для нового броска
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = DiceQuestTheme.colors.Primary
                )
            ) {
                Text(
                    text = "Бросить еще раз",
                    color = DiceQuestTheme.colors.TextPrimary
                )
            }
        } else {
            // Показываем кнопку для броска
            Button(
                onClick = {
                    rollDice()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = DiceQuestTheme.colors.Primary
                ),
                modifier = Modifier
            ) {
                Text(
                    text = "🎲 Бросить кубик",
                    color = DiceQuestTheme.colors.TextPrimary
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDice(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        DiceScreen()

    }
}