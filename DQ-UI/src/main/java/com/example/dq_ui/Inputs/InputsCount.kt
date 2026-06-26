package com.example.dq_ui.Inputs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dq_ui.UI.DiceQuestGradients.Card
import com.example.dq_ui.UI.DiceQuestTheme
import com.example.dq_ui.UI.SpacerH

@Composable
fun PlayerCountSelector(
    selectedCount: Int,
    onCountChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        Text(
            text = "Количество игроков",
            style = DiceQuestTheme.typography.titleMedium,
            color = DiceQuestTheme.colors.TextPrimary

        )

        SpacerH(16)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            (2..4).forEach { count ->

                val selected = count == selectedCount

                Card(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp)
                        .clickable {
                            onCountChange(count)
                        },
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selected)
                            DiceQuestTheme.colors.Primary
                        else
                            DiceQuestTheme.colors.Surface
                    ),
                    border = BorderStroke(
                        width = if (selected) 2.dp else 1.dp,
                        color = if (selected)
                            DiceQuestTheme.colors.PrimaryLight
                        else
                            DiceQuestTheme.colors.SurfaceVariant
                    )
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = count.toString(),
                            style = DiceQuestTheme.typography.headlineMedium,
                            color = DiceQuestTheme.colors.TextPrimary
                        )

                        Text(
                            text = when (count) {
                                2 -> "Игрока"
                                3 -> "Игрока"
                                else -> "Игрока"
                            },
                            style = DiceQuestTheme.typography.bodySmall,
                            color = DiceQuestTheme.colors.TextPrimary.copy(alpha = 0.7f)
                        )
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun PreviewPlayerCountSelector() {

    var Count by remember { mutableStateOf(2) }

    DiceQuestTheme {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DiceQuestTheme.colors.Background)
                .padding(16.dp)
        ) {

            PlayerCountSelector(
                selectedCount = Count,
                onCountChange = {Count = it}
            )

        }
    }
}