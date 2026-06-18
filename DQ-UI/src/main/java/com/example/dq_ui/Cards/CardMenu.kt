package com.example.dq_ui.Cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dq_ui.R
import com.example.dq_ui.UI.DiceQuestTheme
import com.example.dq_ui.UI.SpacerH

@Composable
fun CardMenu(

    nameEvent: String,
    descriptionEvent: String,
    text: String = "Событие",
    imageIventPreview: Painter = painterResource(R.drawable.bonus)
) {

        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)

        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(DiceQuestTheme.colors.Surface)
                    .border(
                        BorderStroke(
                            1.dp,
                            DiceQuestTheme.colors.PrimaryDark.copy(alpha = 0.4f)
                        ),
                        RoundedCornerShape(15.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.padding(vertical = 10.dp)
                        .fillMaxWidth(0.6f),
                    verticalArrangement = Arrangement.spacedBy(20.dp)


                ) {

                    Text(
                        text = nameEvent,
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(DiceQuestTheme.colors.Primary)
                            .fillMaxWidth(),
                        style = DiceQuestTheme.typography.titleLarge,
                        color = DiceQuestTheme.colors.TextPrimary,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = descriptionEvent,
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth(),
                        style = DiceQuestTheme.typography.bodySmall,
                        color = DiceQuestTheme.colors.TextSecondary,
                        textAlign = TextAlign.Center
                    )
                }

                Box(
                    modifier = Modifier
                        .background(
                            DiceQuestTheme.colors.Primary.copy(alpha = 0.08f)
                        )
                ) {
                    Image(
                        painter = imageIventPreview,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                            .padding(24.dp),
                    )
                }
            }

        }
}


@Preview
@Composable
fun PreviewCard(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        CardMenu("Быстрая игра", "Игра с друзьями онлайн (2-4 игрока)")

    }
}


