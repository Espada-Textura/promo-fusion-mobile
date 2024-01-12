package com.promofusion.modules.main.context.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.navigations.views.layouts.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Splash Screen
        installSplashScreen()

        super.onCreate(savedInstanceState)
        this.actionBar?.hide()
        setContent {
            PromoFusionTheme {
                NavigationGraph()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    PromoFusionTheme {
        NavigationGraph()
    }
}