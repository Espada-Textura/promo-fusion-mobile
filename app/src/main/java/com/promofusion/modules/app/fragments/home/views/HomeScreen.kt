package com.promofusion.modules.app.fragments.home.views

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.promofusion.common.ui.components.navigations.BottomNavigationBar
import com.promofusion.common.ui.theme.PromoFusionTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    // A surface container using the 'background' color from the theme
    Scaffold(bottomBar = {
        BottomNavigationBar()
    }) {}
}

@Composable
@Preview
fun HomeScreenPreview() {
    PromoFusionTheme {
        HomeScreen()
    }
}