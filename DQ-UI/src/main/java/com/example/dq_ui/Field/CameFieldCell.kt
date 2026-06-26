package com.example.dq_ui.Field

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dq_ui.R
import com.example.dq_ui.UI.DiceQuestTheme

data class GameCell(
    val index: Int,
    val color: Color = DiceQuestTheme.colors.Surface,
    val tokens: List<Color> = emptyList()
)

@Composable
fun GameFieldCell(
    cell: GameCell,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(cell.color)
            .border(
                1.5.dp,
                if (cell.tokens.isNotEmpty()) {
                    DiceQuestTheme.colors.Primary
                } else {
                    DiceQuestTheme.colors.Primary.copy(alpha = 0.15f)
                },
                RoundedCornerShape(12.dp)
            )
            .padding(4.dp)
    ) {
        Text(
            text = cell.index.toString(),
            style = DiceQuestTheme.typography.labelSmall.copy(
                fontSize = 10.sp
            ),
            color = if (cell.tokens.isNotEmpty()) {
                DiceQuestTheme.colors.TextPrimary
            } else {
                DiceQuestTheme.colors.TextSecondary.copy(alpha = 0.5f)
            },
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(2.dp)
        )

        // Иконка типа ячейки
        when {
            cell.color == DiceQuestTheme.colors.Success.copy(alpha = 0.2f) -> {
                Icon(
                    painter = painterResource(R.drawable.bonus_game),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp).align(Alignment.TopEnd).padding(2.dp),
                    tint = DiceQuestTheme.colors.Success
                )
            }
            cell.color == DiceQuestTheme.colors.Error.copy(alpha = 0.2f) -> {
                Icon(
                    painter = painterResource(R.drawable.penalty),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp).align(Alignment.TopEnd).padding(2.dp),
                    tint = DiceQuestTheme.colors.Error
                )
            }
            cell.color == DiceQuestTheme.colors.SurfaceLight.copy(alpha = 0.2f) -> {
                Icon(
                    painter = painterResource(R.drawable.shield),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp).align(Alignment.TopEnd).padding(2.dp),
                    tint = DiceQuestTheme.colors.SurfaceLight
                )
            }
            cell.color == DiceQuestTheme.colors.Coin.copy(alpha = 0.2f) -> {
                Icon(
                    painter = painterResource(R.drawable.event),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp).align(Alignment.TopEnd).padding(2.dp),
                    tint = DiceQuestTheme.colors.Coin
                )
            }
        }

        // Фишки игроков
        if (cell.tokens.isNotEmpty()) {
            TokenGrid(
                tokens = cell.tokens,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}