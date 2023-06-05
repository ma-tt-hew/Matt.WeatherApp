package com.example.weatherapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.weatherapp.R

// Set up the Font
val CustomFont = FontFamily(
    Font(R.font.futura_normal),
    Font(R.font.futura_bold, FontWeight.Bold),
    Font(R.font.futura_medium, FontWeight.Normal)

)
// Set of Material typography styles to start with

// then set this to be the default font
val Typography = Typography(defaultFontFamily = CustomFont)


