package com.example.dq_ui.icons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.example.dq_ui.UI.DiceQuestTheme

@Composable
fun IconBtn(onClick:() -> Unit,  icon: Painter,size: Int = 32,color: Color = DiceQuestTheme.colors.TextSecondary) {

    Icon(painter = icon,
        contentDescription = null,
        modifier = Modifier
            .size(size.dp)
            .clickable{onClick()},
        tint = color
    )
}