package com.example.dq_ui.UI

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.dq_ui.R

private val QuestFont = FontFamily(
    Font(R.font.quest_regular, FontWeight.Normal),
    Font(R.font.quest_medium, FontWeight.Medium),
    Font(R.font.quest_bold, FontWeight.Bold)
)

val DiceQuestTypography = Typography(

    displayLarge = TextStyle(
        fontFamily = QuestFont,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),

    headlineLarge = TextStyle(
        fontFamily = QuestFont,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),

    titleLarge = TextStyle(
        fontFamily = QuestFont,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),

    titleMedium = TextStyle(
        fontFamily = QuestFont,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),

    bodyLarge = TextStyle(
        fontFamily = QuestFont,
        fontSize = 16.sp
    ),

    bodyMedium = TextStyle(
        fontFamily = QuestFont,
        fontSize = 14.sp
    ),

    bodySmall = TextStyle(
        fontFamily = QuestFont,
        fontSize = 12.sp
    ),

    labelLarge = TextStyle(
        fontFamily = QuestFont,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
)