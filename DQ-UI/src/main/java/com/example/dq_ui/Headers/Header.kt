package com.example.dq_ui.Headers

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dq_ui.R
import com.example.dq_ui.UI.DiceQuestTheme
import com.example.dq_ui.UI.SpacerH
import com.example.dq_ui.UI.SpacerW
import com.example.dq_ui.icons.IconBtn

@Composable
fun Header(text: String,
    leadingIcon: Painter?, trailingIcon: Painter?,
    leadingOnClick: () -> Unit = {}, trailingOnClick: () -> Unit = {},
){

    Row(
        modifier = Modifier.fillMaxWidth().height(64.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (leadingIcon != null) {
            IconBtn(leadingOnClick, leadingIcon,  color = DiceQuestTheme.colors.TextPrimary)
        } else {
            SpacerW(32)
        }

        Text(text = text, style = DiceQuestTheme.typography.headlineLarge, color = DiceQuestTheme.colors.TextPrimary )

        if (trailingIcon != null) {
            IconBtn(trailingOnClick, trailingIcon, color = DiceQuestTheme.colors.TextPrimary)
        } else {
            SpacerW(32)
        }
    }
}

@Preview
@Composable
fun PreviewHeader(){

    Box(modifier = Modifier.padding(horizontal = 20.dp, vertical = 100.dp)) {

        Header("Главная", painterResource(R.drawable.arrow_left), painterResource(R.drawable.share))

    }

}