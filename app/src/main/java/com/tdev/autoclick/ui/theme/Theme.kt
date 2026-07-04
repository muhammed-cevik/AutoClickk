package com.tdev.autoclick.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Black = Color(0xFF000000)
private val DarkSurface = Color(0xFF0D0D0D)
private val DarkContainer = Color(0xFF1A1A1A)
private val AccentWhite = Color(0xFFFFFFFF)
private val AccentGray = Color(0xFF888888)
private val AccentLightGray = Color(0xFFAAAAAA)

private val AutoClickkDarkColorScheme = darkColorScheme(
    primary = AccentWhite,
    onPrimary = Black,
    primaryContainer = DarkContainer,
    onPrimaryContainer = AccentWhite,
    secondary = AccentGray,
    onSecondary = AccentWhite,
    secondaryContainer = DarkContainer,
    onSecondaryContainer = AccentLightGray,
    background = Black,
    onBackground = AccentWhite,
    surface = DarkSurface,
    onSurface = AccentWhite,
    surfaceVariant = DarkContainer,
    onSurfaceVariant = AccentLightGray,
    outline = Color(0xFF333333),
    error = Color(0xFFFF4444),
    onError = Black,
)

@Composable
fun AutoClickkTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AutoClickkDarkColorScheme,
        typography = Typography,
        content = content,
    )
}
