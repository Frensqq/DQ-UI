package com.example.dq_ui.Cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dq_ui.R
import com.example.dq_ui.UI.DiceQuestTheme
import com.example.dq_ui.UI.SpacerH
import org.w3c.dom.Text

@Composable
fun CardEvents(
    nameEvent: String,
    descriptionEvent: String? = null,
    text: String = "Событие",
    textIventPreview: String? = null,
    imageIventPreview: Painter = painterResource(R.drawable.bonus)
) {

    Box(
        modifier = Modifier
            .padding(horizontal = 30.dp, vertical = 50.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(28.dp))
                .background(DiceQuestTheme.colors.Surface)
                .border(
                    BorderStroke(
                        1.dp,
                        DiceQuestTheme.colors.PrimaryDark.copy(alpha = 0.4f)
                    ),
                    RoundedCornerShape(28.dp)
                )
        ) {

            SpacerH(32)

            Box(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .background(
                        DiceQuestTheme.colors.Primary.copy(alpha = 0.08f)
                    )
            ) {

                if (textIventPreview == null){
                    Image(
                        painter = imageIventPreview,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    )
                }else{
                    Text(textIventPreview,
                        style = DiceQuestTheme.typography.displayLarge.copy(fontSize = 152.sp),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = DiceQuestTheme.colors.Primary
                        )
                }
            }

            SpacerH(20)

            Text(
                text = nameEvent,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                style = DiceQuestTheme.typography.headlineSmall,
                color = DiceQuestTheme.colors.TextPrimary,
                textAlign = TextAlign.Center
            )

            if (descriptionEvent != null) {
                Box(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .align(Alignment.CenterHorizontally)
                        .size(width = 67.dp, height = 4.dp)
                        .clip(RoundedCornerShape(50))
                        .background(DiceQuestTheme.colors.Primary)
                )

                Text(
                    text = descriptionEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    style = DiceQuestTheme.typography.bodySmall,
                    color = DiceQuestTheme.colors.TextSecondary,
                    textAlign = TextAlign.Center
                )
            }

                SpacerH(24)

        }


        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .clip(RoundedCornerShape(35))
                .background(DiceQuestTheme.colors.Primary)
                .border(
                    BorderStroke(
                        1.dp,
                        DiceQuestTheme.colors.PrimaryLight
                    ),
                    RoundedCornerShape(35)
                )
                .padding(horizontal = 25.dp, vertical = 5.dp),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = text.uppercase(),
                style = DiceQuestTheme.typography.headlineLarge,
                color = DiceQuestTheme.colors.TextPrimary
            )
        }
    }
}

@Preview
@Composable
fun PreviewCardEvents(){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {

        CardEvents(text = "Результат", nameEvent = "Ваш результат 5", textIventPreview = "5")

    }
}