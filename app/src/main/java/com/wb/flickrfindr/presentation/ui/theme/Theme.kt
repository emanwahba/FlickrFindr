package com.wb.flickrfindr.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = DarkBlue,
    primaryVariant = DarkBlue,
    background = Blue,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color.Black
)

private val LightColorPalette = lightColors(
    primary = LightBlue,
    primaryVariant = LightBlue,
    background = Blue,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color.Black
)

@Composable
fun FlickrFindrTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}