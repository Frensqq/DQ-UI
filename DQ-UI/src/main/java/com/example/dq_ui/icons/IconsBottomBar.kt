package com.example.dq_ui.icons

import android.graphics.drawable.Icon
import androidx.annotation.Size
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dq_ui.R
import com.example.dq_ui.UI.DiceQuestTheme

sealed class BottomNavItem(
    val title: String,
    val icon: Int
) {
    object Home : BottomNavItem("Главная", R.drawable.home)
    object Profile : BottomNavItem("Профиль", R.drawable.profile)
    object History : BottomNavItem("История", R.drawable.history)
    object Settings : BottomNavItem("Настройки", R.drawable.settings)

}

@Composable
fun BottomNavigationPanel(
    selectedItem: BottomNavItem,
    onItemSelected: (BottomNavItem) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)

    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                colors = listOf(
                    DiceQuestTheme.colors.PrimaryDark,
                    DiceQuestTheme.colors.SurfaceVariant
                )),
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            BottomNavItem(
                item = BottomNavItem.Home,
                selected = selectedItem == BottomNavItem.Home,
                onClick = { onItemSelected(BottomNavItem.Home) }
            )

            BottomNavItem(
                item = BottomNavItem.Profile,
                selected = selectedItem == BottomNavItem.Profile,
                onClick = { onItemSelected(BottomNavItem.Profile) }
            )


            BottomNavItem(
                item = BottomNavItem.History,
                selected = selectedItem == BottomNavItem.History,
                onClick = { onItemSelected(BottomNavItem.History) }
            )

            BottomNavItem(
                item = BottomNavItem.Settings,
                selected = selectedItem == BottomNavItem.Settings,
                onClick = { onItemSelected(BottomNavItem.Settings) }
            )
        }
    }
}

@Composable
fun BottomNavItem(
    item: BottomNavItem,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .clickable { onClick() }
            .width(70.dp)
    ) {
        Icon(
            painter = painterResource(item.icon),
            contentDescription = item.title,
            modifier = Modifier.size(35.dp),
            tint = if (selected) DiceQuestTheme.colors.PrimaryLight else DiceQuestTheme.colors.TextSecondary
        )

        Text(
            text = item.title,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            style = DiceQuestTheme.typography.bodySmall,
            color = if (selected) DiceQuestTheme.colors.PrimaryLight else DiceQuestTheme.colors.TextSecondary,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewBottomNavigationPanel() {
    var selectedItem by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Home) }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center) {
        BottomNavigationPanel(
            selectedItem = selectedItem,
            onItemSelected = { selectedItem = it }
        )
    }
}