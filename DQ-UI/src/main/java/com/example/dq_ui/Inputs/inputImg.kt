package com.example.dq_ui.Inputs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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

@Composable
fun InputsImage(onClick: () -> Unit,painter: Painter?, state: Boolean){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 205.dp)
            .clip(androidx.compose.foundation.shape.RoundedCornerShape(17.dp))
            .border(3.dp, DiceQuestTheme.colors.Primary, shape = RoundedCornerShape(17.dp))
            .background(DiceQuestTheme.colors.SurfaceVariant.copy(alpha = 0.2f))

    ) {

        if (!state || painter == null) {
            Row(
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(start = 5.dp, end = 6.dp, bottom = 18.dp, top = 22.dp),
                    contentAlignment = Alignment.Center

                ){
                    Icon(
                        painter = painterResource(R.drawable.icon_plus),
                        contentDescription = null, tint = DiceQuestTheme.colors.Primary,
                        modifier = Modifier
                            .clickable { onClick() }
                            .size(120.dp)
                    )
                }


            }
        } else {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(start = 5.dp, end = 6.dp, bottom = 18.dp, top = 22.dp),
                contentAlignment = Alignment.Center

            ) {
                Box(Modifier.fillMaxSize().padding(start = 5.dp, end = 6.dp, bottom = 18.dp, top =22.dp )) {
                    Image(
                        painter = painter,
                        contentDescription = "Selected image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )
                }
            }

        }

    }
}

@Preview
@Composable
fun PreviewInputsImage(){

    Column(modifier = Modifier.padding(vertical = 150.dp)) {
        InputsImage({}, null, true)

    }

}