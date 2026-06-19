package com.example.dq_ui.Dice

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dq_ui.Cards.CardEvents
import com.example.dq_ui.UI.DiceQuestTheme
import com.example.dq_ui.UI.SpacerH
import kotlinx.coroutines.delay

class DiceViewModel : ViewModel() {
    var diceValue by mutableStateOf(1)
        private set

    var isRolling by mutableStateOf(false)
        private set

    var rotation by mutableStateOf(0f)
        private set

    suspend fun rollDiceWithAnimation(onResult: (String) -> Unit) {
        isRolling = true

        val steps = 6
        val stepDelay = 150L

        repeat(steps) { step ->
            rotation += 60f
            diceValue = (1..6).random()
            delay(stepDelay)
        }

        rotation += 360f
        diceValue = (1..6).random()
        delay(200)

        isRolling = false
        onResult(diceValue.toString())  // Возвращаем результат
    }
}

@Composable
fun DiceWithAnimation(
    value: Int,
    rotation: Float,
    isRolling: Boolean,
    isEnabled: Boolean,
    onClick: () -> Unit
) {

    val diceFaces = mapOf(
        1 to "⚀",
        2 to "⚁",
        3 to "⚂",
        4 to "⚃",
        5 to "⚄",
        6 to "⚅"
    )

    val animatedRotation by animateFloatAsState(
        targetValue = rotation,
        animationSpec = tween(
            durationMillis = 350,
            easing = FastOutSlowInEasing
        ),
        label = "diceRotation"
    )

    Box(
        modifier = Modifier
            .size(140.dp)
            .shadow(
                elevation = 12.dp,
                shape = RoundedCornerShape(24.dp)
            )
            .clip(RoundedCornerShape(24.dp))
            .background(
                when {
                    isRolling ->
                        DiceQuestTheme.colors.Primary.copy(alpha = 0.15f)

                    !isEnabled ->
                        DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.5f)

                    else ->
                        DiceQuestTheme.colors.Surface
                }
            )
            .border(
                BorderStroke(
                    2.dp,
                    when {
                        isRolling ->
                            DiceQuestTheme.colors.Primary

                        !isEnabled ->
                            DiceQuestTheme.colors.TextSecondary.copy(alpha = 0.3f)

                        else ->
                            DiceQuestTheme.colors.PrimaryDark.copy(alpha = 0.4f)
                    }
                ),
                RoundedCornerShape(24.dp)
            )
            .rotate(animatedRotation)
            .clickable(
                enabled = isEnabled && !isRolling
            ) {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = if (isRolling)
                "?"
            else
                diceFaces[value] ?: "?",
            fontSize = if (isRolling) 36.sp else 72.sp,
            fontWeight = FontWeight.Bold,
            color = DiceQuestTheme.colors.TextPrimary
        )
    }
}

@Composable
fun DiceScreen(
    viewModel: DiceViewModel = viewModel(),

    isEnabled: Boolean = true,

    onResult: (Int) -> Unit
) {

    val diceValue by viewModel::diceValue
    val isRolling by viewModel::isRolling
    val rotation by viewModel::rotation

    var lastResult by remember {
        mutableStateOf<Int?>(null)
    }

    var triggerRoll by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(triggerRoll) {

        if (triggerRoll) {

            viewModel.rollDiceWithAnimation { result ->

                val value = result.toInt()

                lastResult = value

                onResult(value)
            }

            triggerRoll = false
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            DiceWithAnimation(
                value = diceValue,
                rotation = rotation,
                isRolling = isRolling,
                isEnabled = isEnabled,
                onClick = {

                    if (
                        isEnabled &&
                        !isRolling
                    ) {
                        triggerRoll = true
                    }
                }
            )

            SpacerH(12)

            Text(
                text = when {
                    isRolling -> "Бросаем кубик..."
                    !isEnabled -> "Ожидание других игроков"
                    else -> "Нажмите для броска"
                },
                style = DiceQuestTheme.typography.bodyMedium,
                color = DiceQuestTheme.colors.TextSecondary
            )
        }

        // Модальное окно результата
        lastResult?.let { result ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.45f))
                    .clickable {
                        lastResult = null
                    },
                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = remember {
                            MutableInteractionSource()
                        }
                    ) { }
                ) {

                    CardEvents(
                        text = "Результат",
                        nameEvent = "Ваш результат $result",
                        textIventPreview = result.toString()
                    )
                }
            }
        }
    }
}

@Composable
fun DiceResultCard(
    result: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(top = 24.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(DiceQuestTheme.colors.Surface)
            .border(
                BorderStroke(
                    1.dp,
                    DiceQuestTheme.colors.Primary.copy(alpha = 0.4f)
                ),
                RoundedCornerShape(20.dp)
            )
            .padding(
                horizontal = 24.dp,
                vertical = 16.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Выпало $result",
            style = DiceQuestTheme.typography.titleMedium,
            color = DiceQuestTheme.colors.TextPrimary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDiceScreen() {

    var result by remember {
        mutableStateOf<Int?>(null)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DiceQuestTheme.colors.Background),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            DiceScreen(
                isEnabled = true,
                onResult = {
                    result = it
                }
            )

            result?.let {
                Text(
                    text = "Последний результат: $it",
                    style = DiceQuestTheme.typography.bodyLarge,
                    color = DiceQuestTheme.colors.TextPrimary,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}