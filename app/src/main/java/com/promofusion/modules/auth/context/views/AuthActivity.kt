package com.promofusion.modules.auth.context.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.auth.fragments.auth.views.LoginScreen

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Splash Screen
        installSplashScreen()

        super.onCreate(savedInstanceState)
        this.actionBar?.hide()
        setContent {
            PromoFusionTheme {
                LoginScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AuthActivityView() {
    PromoFusionTheme {
        LoginScreen()
    }
}