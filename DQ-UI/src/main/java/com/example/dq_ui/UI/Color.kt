package com.example.dq_ui.UI

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


object DiceQuestColors {

    // Backgrounds
    val Background = Color(0xFF070B1D)
    val Surface = Color(0xFF10162F)
    val SurfaceVariant = Color(0xFF171E3F)

    // Primary
    val Primary = Color(0xFF8B3DFF)
    val PrimaryLight = Color(0xFFA85BFF)
    val PrimaryDark = Color(0xFF6D28D9)

    // Secondary
    val Secondary = Color(0xFF5B2ABF)

    // States
    val Success = Color(0xFF4CAF50)
    val SuccessDark = Color(0xFF387A3A)
    val Error = Color(0xFFE53935)
    val Warning = Color(0xFFFFC107)

    // Rewards
    val Coin = Color(0xFFFFC107)
    val Trophy = Color(0xFFFFB300)

    // Text
    val TextPrimary = Color(0xFFFFFFFF)
    val TextSecondary = Color(0xFFB8BED8)
    val TextHint = Color(0xFF7A82A6)

    // Border
    val Border = Color(0xFF2A325A)

    // Overlay
    val Overlay = Color(0x99000000)
}

object DiceQuestGradients {

    val PrimaryButton = Brush.horizontalGradient(
        colors = listOf(
            DiceQuestColors.Primary,
            DiceQuestColors.PrimaryLight
        )
    )

    val PrimaryGreenButton = Brush.horizontalGradient(
        colors = listOf(
            DiceQuestColors.SuccessDark,
            DiceQuestColors.Success
        )
    )

    val Card = Brush.verticalGradient(
        colors = listOf(
            DiceQuestColors.SurfaceVariant,
            DiceQuestColors.Surface
        )
    )

    val Victory = Brush.horizontalGradient(
        colors = listOf(
            DiceQuestColors.Warning,
            DiceQuestColors.Trophy
        )
    )

    val PurpleGlow = Brush.radialGradient(
        colors = listOf(
            DiceQuestColors.PrimaryLight,
            DiceQuestColors.PrimaryDark
        )
    )
}