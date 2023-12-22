package com.promofusion.common.ui.theme

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
    background = Neutral900,
    onBackground = Neutral50,

    surface = Neutral900,
    onSurface = Neutral50,
    surfaceVariant = Neutral800,
    onSurfaceVariant = Neutral50,
    inverseSurface = Neutral100,
    inverseOnSurface = Neutral950,
    surfaceTint = Neutral50,

    primary = RadicalRed600,
    onPrimary = RadicalRed50,
    primaryContainer = RadicalRed700,
    onPrimaryContainer = RadicalRed50,
    inversePrimary = RadicalRed400,

    secondary = PersianGreen600,
    onSecondary = PersianGreen50,
    secondaryContainer = PersianGreen700,
    onSecondaryContainer = PersianGreen50,

    tertiary = Violet600,
    onTertiary = Violet50,
    tertiaryContainer = Violet700,
    onTertiaryContainer = Violet50,

    error = Red600,
    onError = Red50,
    errorContainer = Red800,
    onErrorContainer = Red500,

    outline = Neutral800,
    outlineVariant = Neutral700,

    scrim = Neutral600
)

private val lightModeScheme = lightColorScheme(

    background = Color.White,
    onBackground = Neutral950,

    surface = Neutral50,
    onSurface = Neutral950,
    surfaceVariant = Neutral100,
    onSurfaceVariant = Neutral950,
    inverseSurface = Neutral900,
    inverseOnSurface = Neutral50,
    surfaceTint = Neutral50,

    primary = RadicalRed500,
    onPrimary = RadicalRed50,
    primaryContainer = RadicalRed300,
    onPrimaryContainer = RadicalRed950,
    inversePrimary = RadicalRed600,

    secondary = PersianGreen500,
    onSecondary = PersianGreen50,
    secondaryContainer = PersianGreen300,
    onSecondaryContainer = PersianGreen950,

    tertiary = Violet500,
    onTertiary = Violet50,
    tertiaryContainer = Violet300,
    onTertiaryContainer = Violet950,

    error = Red600,
    onError = Red50,
    errorContainer = Red800,
    onErrorContainer = Red500,

    outline = Neutral200,
    outlineVariant = Neutral300,

    scrim = Neutral400
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
            window.statusBarColor = colorScheme.background.toArgb()
            window.navigationBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }


    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}