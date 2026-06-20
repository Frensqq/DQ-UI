package com.example.dq_ui.Cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.dq_ui.UI.DiceQuestTheme
import com.example.dq_ui.UI.SpacerW

data class UserListForCard(
    val avatar: Painter,
    val userName: String,
    val state: Boolean,
)

@Composable
fun CardUserList(
    data: List<UserListForCard>
){
    Column(modifier = Modifier
        .heightIn(min = 50.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(DiceQuestTheme.colors.SurfaceVariant)
        ) {
        data.forEach { it ->
            Row(horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(DiceQuestTheme.colors.Surface),
                    contentAlignment = Alignment.Center
                ) {
                    if (it.avatar != null) {
                        Image(
                            it.avatar,
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )
                    }
                }
                SpacerW(5)

                Text(
                    it.userName,
                    style = DiceQuestTheme.typography.bodyMedium,
                    color = DiceQuestTheme.colors.TextSecondary
                )

                if (it.state){
                Text(
                    "Ход",
                    modifier = Modifier.padding(horizontal = 5.dp),
                    style = DiceQuestTheme.typography.bodySmall,
                    color = DiceQuestTheme.colors.Primary
                )
                }
            }
        }
    }
}