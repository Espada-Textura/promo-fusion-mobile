package com.promofusion.common.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkModeScheme = darkColorScheme(
    background = Stone950,
    onBackground = Stone50,

    surface = Stone900,
    onSurface = Stone50,
    surfaceVariant = Stone800,
    onSurfaceVariant = Stone50,
    inverseSurface = Stone100,
    inverseOnSurface = Stone950,
    surfaceTint = Stone50,

    primary = RadicalRed600,
    onPrimary = RadicalRed50,
    primaryContainer = RadicalRed700,
    onPrimaryContainer = RadicalRed50,
    inversePrimary = RadicalRed400,

    secondary = Stone800,
    onSecondary = Stone50,
    secondaryContainer = Stone700,
    onSecondaryContainer = Stone50,

    tertiary = Violet600,
    onTertiary = Violet50,
    tertiaryContainer = Violet700,
    onTertiaryContainer = Violet50,

    error = Red600,
    onError = Red50,
    errorContainer = Red800,
    onErrorContainer = Red500,

    outline = Stone800,
    outlineVariant = Stone700,

    scrim = Stone600
)

private val lightModeScheme = lightColorScheme(

    background = Color.White,
    onBackground = Stone950,

    surface = Stone50,
    onSurface = Stone950,
    surfaceVariant = Stone100,
    onSurfaceVariant = Stone950,
    inverseSurface = Stone900,
    inverseOnSurface = Stone50,
    surfaceTint = Stone50,

    primary = RadicalRed500,
    onPrimary = RadicalRed50,
    primaryContainer = RadicalRed300,
    onPrimaryContainer = RadicalRed950,
    inversePrimary = RadicalRed600,

    secondary = Stone50,
    onSecondary = Stone950,
    secondaryContainer = Stone50,
    onSecondaryContainer = Stone950,

    tertiary = Violet500,
    onTertiary = Violet50,
    tertiaryContainer = Violet300,
    onTertiaryContainer = Violet950,

    error = Red600,
    onError = Red50,
    errorContainer = Red800,
    onErrorContainer = Red500,

    outline = Stone200,
    outlineVariant = Stone300,

    scrim = Stone400
)

@Composable
fun PromoFusionTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+

    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkModeScheme
        else -> lightModeScheme
    }

    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            window.navigationBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }


    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}