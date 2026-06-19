package com.example.dq_ui.Cards

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dq_ui.R
import com.example.dq_ui.UI.DiceQuestTheme
import com.example.dq_ui.UI.SpacerW
import com.example.dq_ui.icons.IconBtn

@Composable
fun CardUser(avatar: Painter? = null, name: String = "User", onClickIcon: () -> Unit, icon: Painter = painterResource(R.drawable.settings)){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(DiceQuestTheme.colors.Surface)
            ) {
                if (avatar != null) {
                    Image(
                        avatar,
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            SpacerW(10)

            Text(
                "Привет, $name!",
                style = DiceQuestTheme.typography.titleLarge,
                color = DiceQuestTheme.colors.TextSecondary
            )
        }

        IconBtn(onClickIcon, icon)
    }
}

@Preview
@Composable
fun PreviewCardUser(){

    CardUser(onClickIcon = {})

}