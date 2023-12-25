package com.promofusion.modules.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.promofusion.common.ui.theme.PromoFusionTheme
import com.promofusion.modules.app.viewmodels.NavigationGraph

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.ui.text.font.FontFamily
import com.promofusion.common.ui.theme.lobster

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Splash Screen Transition
        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContent {
            PromoFusionTheme {
                NavigationGraph()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenContent() {
    Text(
        modifier = Modifier
            .width(200.dp)
            .height(36.dp),
        text = "PromoFusion",
        style = TextStyle(
            fontSize = 30.sp,
            lineHeight = 36.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFFFFF1F2),
            textAlign = TextAlign.Center,
        )
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier.fillMaxWidth(),
        fontWeight = FontWeight.ExtraBold,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PromoFusionTheme {
        Greeting("Android")
    }
}