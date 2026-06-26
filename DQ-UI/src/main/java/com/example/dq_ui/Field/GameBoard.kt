package com.example.dq_ui.Field

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dq_ui.UI.DiceQuestTheme

@Composable
fun GameBoard(
    cells: List<GameCell>
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        modifier = Modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        items(cells.size) { index ->

            GameFieldCell(
                cell = cells[index],
                modifier = Modifier.size(52.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameBoard70Fixed() {

    val cells = remember {

        List(70) { index ->

            GameCell(
                index = index + 1,
                color = when {
                    index % 11 == 0 ->
                        DiceQuestTheme.colors.Success.copy(alpha = 0.2f)
                    index % 5 == 0 ->
                        DiceQuestTheme.colors.Error.copy(alpha = 0.2f)
                    index % 6 == 0 ->
                        DiceQuestTheme.colors.SurfaceLight.copy(alpha = 0.2f)
                    index % 13 == 0 ->
                        DiceQuestTheme.colors.Coin.copy(alpha = 0.2f)
                    else ->
                        DiceQuestTheme.colors.Surface
                },
                tokens = when (index) {
                    3 -> listOf(Color.Red)
                    7 -> listOf(Color.Blue)
                    15 -> listOf(Color.Green, Color.Yellow, Color.White, Color.Black)
                    22 -> listOf(Color.Magenta)
                    else -> emptyList()
                }
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DiceQuestTheme.colors.Background)
    ) {

        GameBoard(
            cells = cells
        )
    }
}