package com.example.dq_ui.icons

import android.graphics.drawable.Icon
import androidx.annotation.Size
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dq_ui.R
import com.example.dq_ui.UI.DiceQuestTheme

@Composable
fun iconBtn(onClick:() -> Unit, size: Int, icon: Painter,color: Color = DiceQuestTheme.colors.Primary) {

    Icon(painter = icon,
        contentDescription = null,
        modifier = Modifier
            .size(size.dp)
            .clickable{onClick()},
        tint = color
        )
}