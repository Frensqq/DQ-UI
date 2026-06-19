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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dq_ui.Cards.CardEvents
import com.example.dq_ui.UI.DiceQuestTheme
import com.example.dq_ui.UI.SpacerH
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

@Composable
fun DiceWidget(
    modifier: Modifier = Modifier,
    viewModel: DiceViewModel = viewModel(),
    isEnabled: Boolean = true,
    onResult: (Int) -> Unit
) {

    val diceValue by viewModel::diceValue
    val isRolling by viewModel::isRolling
    val rotation by viewModel::rotation

    var triggerRoll by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(triggerRoll) {

        if (triggerRoll) {

            viewModel.rollDiceWithAnimation {

                onResult(it)
            }

            triggerRoll = false
        }
    }

    val animatedRotation by animateFloatAsState(
        targetValue = rotation,
        animationSpec = tween(
            durationMillis = 350,
            easing = FastOutSlowInEasing
        ),
        label = ""
    )

    val diceFaces = mapOf(
        1 to "⚀",
        2 to "⚁",
        3 to "⚂",
        4 to "⚃",
        5 to "⚄",
        6 to "⚅"
    )

    Box(
        modifier = modifier
            .size(110.dp)
            .shadow(
                10.dp,
                RoundedCornerShape(35.dp)
            )
            .clip(RoundedCornerShape(35.dp))
            .background(
                if (isRolling)
                    DiceQuestTheme.colors.Primary
                else
                    DiceQuestTheme.colors.Surface
            )
            .border(
                BorderStroke(
                    2.dp,
                    DiceQuestTheme.colors.Primary
                ),
                RoundedCornerShape(35.dp)
            )
            .rotate(animatedRotation)
            .clickable(
                enabled = isEnabled && !isRolling
            ) {

                triggerRoll = true
            },
        contentAlignment = Alignment.TopCenter
    ) {

        Text(
            text = if (isRolling)
                "•"
            else
                diceFaces[diceValue] ?: "•",
            lineHeight = 100.sp,
            fontSize = 80.sp,
            color = DiceQuestTheme.colors.TextPrimary
        )
    }
}


@Composable
fun DiceResultDialog(
    result: Int,
    onDismiss: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color.Black.copy(alpha = 0.45f)
            )
            .clickable {
                onDismiss()
            },
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier.clickable(
                indication = null,
                interactionSource = remember {
                    MutableInteractionSource()
                }
            ) {}
        ) {

            CardEvents(
                text = "Результат",
                nameEvent = "Ваш результат $result",
                textIventPreview = result.toString()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDiceWidgetWithResult() {

    var result by remember { mutableStateOf<Int?>(null) }

    var isRolling by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DiceQuestTheme.colors.Background)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            DiceWidget(
                isEnabled = true,
                onResult = { value ->
                    result = value
                }
            )

            SpacerH(16)

            Text(
                text = "Нажмите на кубик",
                style = DiceQuestTheme.typography.bodyMedium,
                color = DiceQuestTheme.colors.TextSecondary
            )

            Text(
                text = "Предыдущий результат $result",
                style = DiceQuestTheme.typography.bodyMedium,
                color = DiceQuestTheme.colors.TextSecondary
            )

            SpacerH(24)

            Button(
                onClick = {
                    // имитация броска через кнопку (для Preview)
                    scope.launch {
                        isRolling = true
                        delay(800)
                        result = (1..6).random()
                        isRolling = false
                    }
                }
            ) {
                Text("Simulate Roll")
            }
        }

        // 🔥 МОДАЛКА РЕЗУЛЬТАТА
        result?.let { value ->

            DiceResultDialog(
                result = value,
                onDismiss = {
                    result = null
                }
            )
        }
    }
}