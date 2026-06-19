package com.example.dq_ui.Field

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
            .size(64.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(cell.color)
            .border(
                1.dp,
                DiceQuestTheme.colors.Primary.copy(alpha = 0.25f),
                RoundedCornerShape(14.dp)
            )
            .padding(6.dp)
    ) {

        // номер клетки
        Text(
            text = cell.index.toString(),
            style = DiceQuestTheme.typography.labelSmall,
            color = DiceQuestTheme.colors.TextSecondary,
            modifier = Modifier.align(Alignment.TopEnd)
        )

        // фишки (до 4)
        TokenGrid(
            tokens = cell.tokens,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}