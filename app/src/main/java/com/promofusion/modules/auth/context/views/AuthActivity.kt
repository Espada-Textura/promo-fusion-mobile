package com.promofusion.modules.auth.context.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.promofusion.common.theme.PromoFusionTheme
import com.promofusion.modules.auth.context.viewmodels.AuthViewModel
import com.promofusion.modules.auth.fragments.auth.views.LoginScreen

class AuthActivity : ComponentActivity() {

//    private lateinit var viewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        //Splash Screen
        installSplashScreen()

//        viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        super.onCreate(savedInstanceState)
        this.actionBar?.hide()


        setContent {
            PromoFusionTheme {
//                LoginScreen(onLoginClick = viewModel::login)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AuthActivityView() {
    PromoFusionTheme {
//        LoginScreen(onLoginClick = { _, _ -> })
    }
}