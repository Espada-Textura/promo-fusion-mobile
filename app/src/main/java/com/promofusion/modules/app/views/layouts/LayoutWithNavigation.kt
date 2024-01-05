package com.promofusion.modules.app.views.layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.promofusion.modules.app.views.components.BottomNavigationBar


@Composable
fun LayoutWithNavigation(
    navHostController: NavHostController, content: @Composable ((Modifier) -> Unit)
) {
    Scaffold(bottomBar = { BottomNavigationBar(navHostController = navHostController) }) { paddingValue ->
        content(Modifier.padding(paddingValue))
    }
}
