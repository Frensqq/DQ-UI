package com.example.dq_ui.icons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dq_ui.R
import com.example.dq_ui.UI.DiceQuestTheme

@Composable
fun ExitBtn(onClick:() -> Unit, size: Int = 32){

    Box(modifier = Modifier.size(size.dp).clip(CircleShape).background(DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.8f)).padding(2.dp)) {
        Icon(
            painter = painterResource(R.drawable.cross),
            contentDescription = null,
            modifier = Modifier
                .size(size.dp)
                .clickable { onClick() },
            tint = DiceQuestTheme.colors.TextPrimary
        )
    }
}