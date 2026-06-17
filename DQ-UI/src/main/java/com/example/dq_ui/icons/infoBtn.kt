package com.example.dq_ui.icons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dq_ui.R
import com.example.dq_ui.UI.DiceQuestTheme

@Composable
fun InfoBtn(onClick:() -> Unit, size: Int = 50){

    Box(modifier = Modifier.size(size.dp).clip(RoundedCornerShape(10.dp)).background(DiceQuestTheme.colors.SurfaceVariant).padding(7.dp)) {
        Icon(
            painter = painterResource(R.drawable.settings),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClick() },
            tint = DiceQuestTheme.colors.TextSecondary
        )
    }
}