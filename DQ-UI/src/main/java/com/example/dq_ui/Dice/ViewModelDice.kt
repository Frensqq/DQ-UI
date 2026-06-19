package com.example.dq_ui.Dice

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class DiceViewModel : ViewModel() {

    var diceValue by mutableStateOf(1)
        private set

    var isRolling by mutableStateOf(false)
        private set

    var rotation by mutableStateOf(0f)
        private set

    suspend fun rollDiceWithAnimation(
        onResult: (Int) -> Unit
    ) {

        isRolling = true

        repeat(6) {

            rotation += 60f
            diceValue = (1..6).random()

            delay(150)
        }

        rotation += 360f

        diceValue = (1..6).random()

        delay(200)

        isRolling = false

        onResult(diceValue)
    }
}
