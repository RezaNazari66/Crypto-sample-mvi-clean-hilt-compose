package com.rezanazari.core.ui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rezanazari.core.R

private val cryptoFont = FontFamily(
    Font(R.font.vazir_bold, FontWeight.Bold),
    Font(R.font.vazir_light, FontWeight.Normal)
)



val AppTypography = Typography(
    titleMedium = TextStyle(
        fontFamily = cryptoFont,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = cryptoFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)
